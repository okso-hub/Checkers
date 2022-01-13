import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;

public class Black extends Sides {
    
    // Attribute

    public Black() {
        for(int i = 0; i < pieces.length; i++)
        {
            pieces[i] = new Piece(false);
        }
        
        color = "rot";
    }
    
    public void moveBlack(int pieceNum, int direction) {

        
        Main.updatePiecePositions();
        
        
        /* ------------------------------------------------- */
        
        if(!pieces[pieceNum].checkKill() && !pieces[pieceNum].checkField(new int[]{}))
        {
            System.out.println(String.valueOf(pieces[pieceNum].checkKill()) + " <---------- ist checkKill richtif???");
            pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction, pieces[pieceNum].gridPos[1] - 1});
            Main.updatePiecePositions();
        } 
         else if(pieces[pieceNum].checkKill())
        {
            Main.updatePiecePositions();
            if (Stein.piecePositions[pieces[pieceNum].gridPos[0] - 1][pieces[pieceNum].gridPos[1] - 1] == 1)
            {
                Main.killWhitePiece(new int[]{pieces[pieceNum].gridPos[0] - 1, pieces[pieceNum].gridPos[1] + 1});
                Main.updatePiecePositions();
                System.out.println("Töten nach links oben");
                
                pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction * 2, pieces[pieceNum].gridPos[1] - 2});
                Main.updatePiecePositions();
                
            } else if (Stein.piecePositions[pieces[pieceNum].gridPos[0] + 1][pieces[pieceNum].gridPos[1] - 1] == 1) {
                Main.killWhitePiece(new int[]{pieces[pieceNum].gridPos[0] + 1, pieces[pieceNum].gridPos[1] - 1});
                Main.updatePiecePositions();
                System.out.println("Töten nach rechts oben");
            }
        }
        Main.updateScreen();
    }
      
    public Shape gibAktuelleFigur()
    {
        piecesShape.reset();
        for(Piece piece : pieces)
        {
            piece.resetNewPiece();
            if (!piece.isDead) {
                piecesShape.append(piece.gibAktuelleFigur(), false);
            }
        }
        return transform(piecesShape);
    }
}

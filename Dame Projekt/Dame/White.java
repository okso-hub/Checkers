import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;

public class White extends Sides {
      
    
    public White() {
        for(int i = 0; i < pieces.length; i++)
        {
            pieces[i] = new Piece(true);
        }
        
        color = "blau";
    }
    
    
    public void moveWhite(int pieceNum, int direction) {
        
        if(!pieces[pieceNum].checkKill() && !pieces[pieceNum].checkField())
        {
            System.out.println(String.valueOf(pieces[pieceNum].checkKill()) + " <---------- ist checkKill richtif???");
            pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction, pieces[pieceNum].gridPos[1] + 1});
            Main.updatePiecePositions();
        } 
         else if(pieces[pieceNum].checkKill())
        {
            Main.updatePiecePositions();
            if (Stein.piecePositions[pieces[pieceNum].gridPos[0] - 1][pieces[pieceNum].gridPos[1] + 1] == 2)
            {
                Main.killBlackPiece(new int[]{pieces[pieceNum].gridPos[0] - 1, pieces[pieceNum].gridPos[1] + 1});
                Main.updatePiecePositions();
                System.out.println("Töten nach links unten");
                
                pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction * 2, pieces[pieceNum].gridPos[1] + 2});
                Main.updatePiecePositions();
                
            } else if (Stein.piecePositions[pieces[pieceNum].gridPos[0] + 1][pieces[pieceNum].gridPos[1] + 1] == 2) {
                Main.killBlackPiece(new int[]{pieces[pieceNum].gridPos[0] + 1, pieces[pieceNum].gridPos[1] + 1});
                Main.updatePiecePositions();
                System.out.println("Töten nach rechts unten");
            }
        }
        Main.updateScreen();
    }
    
    public boolean debug()
    {
        return pieces[9].checkKill();
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

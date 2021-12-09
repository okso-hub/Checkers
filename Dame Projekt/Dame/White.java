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
        loesche();
        if(!pieces[pieceNum].checkKill() && !pieces[pieceNum].checkField(new int[]{}))
        {
            System.out.println(String.valueOf(pieces[pieceNum].checkKill()) + " <---------- ist checkKill richtif???");
            pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction, pieces[pieceNum].gridPos[1] + 1});
            Main.updatePiecePositions();
        } 
         else if(pieces[pieceNum].checkKill())
        {
            pieces[pieceNum].checkKill();
            Main.updatePiecePositions();
            System.out.println("hey na you can kill now!!!!!!!");
        }
        zeichne();
    }
    
    public Shape gibAktuelleFigur()
    {
        
        piecesShape.reset();
        for(Piece piece : pieces)
        {
            piece.resetNewPiece();
            piecesShape.append(piece.gibAktuelleFigur(), false);
        }
        
        return transform(piecesShape);
    }
}

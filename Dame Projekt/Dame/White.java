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
        if(!piece[piecenum].checkKill() && !piece[pieceNum].checkField(new int[]{}))
        {
            pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction, pieces[pieceNum].gridPos[1] + 1});
        } 
         else if(piece[pieceNum].checkKill())
        {
            System.out.println("hey na you can killing now!!!!!!!");
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

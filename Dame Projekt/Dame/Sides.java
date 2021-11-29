import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;

public abstract class Sides extends Stein
{
    protected Piece[] pieces = new Piece[12];
    GeneralPath piecesShape = new GeneralPath();
    
    protected void positionWhitePieces() {
        int p = 0;
        int right = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                pieces[p].gridPos[0] = j*2 + right;
                pieces[p].gridPos[1] = i;
                
                pieces[p].resetNewPiece();
                p++;
            }
            
            // if(right){pieces[p].gridPos[0]++;}
            right = (right == 0) ? 1 : 0;
        }
    }
    
    protected void positionBlackPieces() {
        int p = 0;
        int right = 0;
        for (int i = 5; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                pieces[p].gridPos[0] = j*2 + right;
                pieces[p].gridPos[1] = i;
                
                pieces[p].resetNewPiece();
                p++;
            }
            
            // if(right){pieces[p].gridPos[0]++;}
            right = (right == 0) ? 1 : 0;
        }
    }
}
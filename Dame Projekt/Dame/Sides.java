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
        for (int i = 5; i < 8; i++) {
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
    
    protected int[][] getPiecePosition()
    {
        int[][] posses = new int[8][8];
        
        for (int i = 0; i < posses.length; i++) {
            for(Piece piece : pieces) {
                if (piece.gridPos[0] == i) { 
                    // System.out.println("Is dead? --> " + isDead);
                    if(!piece.isDead)
                    {
                       posses[piece.gridPos[0]][piece.gridPos[1]] = (color == "blau") ? 1 : 2; 
                    }               
                }
            }
        }
        
        return posses;
    }
    
    protected void kill(int[] position) {
        System.out.println("Methode wird ausgefuehrt");
        for (Piece piece : pieces) {
            System.out.println(piece.gridPos[0] + " " + piece.gridPos[1]);
            System.out.println(position[0] + " " + position[1]);
            System.out.println("---------------------------");
            if (piece.gridPos[0] == position[0] && piece.gridPos[1] == position[1]) {
                piece.die();
                System.out.println("Figur isDead");
                break;
            }
        }
    }   
}
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;

/**
 * Ein Piece, der manipuliert werden kann und sich selbst auf einer Leinwand zeichnet.
 * 
 * @author Claus Albowski
 * @version 2.2  (aug 07)
 */
public class Piece extends Stein 
{   
    
    protected int diameter;
    protected int syntax;
    
    /**
     * Erzeuge einen neuen Stuhl mit einer Standardcolor und Standardgroesse
     * an einer Standardposition. (Standardkonstruktor)
     */
    public Piece(boolean isWhite)  {
        pos[0] = 10;
        pos[1] = 10;
        color = (isWhite) ? "blau" : "schwarz";
        syntax = (isWhite) ? 1 : 2;
        istSichtbar = false;
        diameter = 40;
    }
    
    protected void movePiece(int[] newPos)
    {
        loesche();
        System.out.println(newPos[0] + "PERFecto");
        System.out.println(newPos[1] + "perfextro");
        gridPos[0] = newPos[0];
        gridPos[1] = newPos[1];
        
        resetNewPiece();
        
        zeichne();
    }
    
    public void resetNewPiece() {
        pos[0] = (gridPos[0] * 50) - diameter / 2;
        pos[1] = (gridPos[1] * 50) - diameter / 2;
        pos[0] = pos[0] + 25;
        pos[1] = pos[1] + 25;
    }

    protected boolean checkKill()
    {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        switch (syntax) {
            case 1:
                 System.out.println(Stein.piecePositions[gridPos[0] + 1][gridPos[1] + 1]);
                 if(Stein.piecePositions[gridPos[0] + 1][gridPos[1] + 1] == 2) {
                     System.out.println("Nach unten rechts gibt es einen gegner!");
                     if (Stein.piecePositions[gridPos[0] + 2][gridPos[1] + 2] == 0) {
                         System.out.println(gridPos[0] + " Rechts! " + gridPos[1]);
                         return true;
                     }
                 }
                 
                 if(Stein.piecePositions[gridPos[0] - 1][gridPos[1] + 1] == 2) {
                     System.out.println("Nach unten links gibt es einen gegner!");
                     if (Stein.piecePositions[gridPos[0] - 2][gridPos[1] + 2] == 0) {
                         System.out.println(gridPos[0] + " Links! " + gridPos[1]);
                         return true;
                     }
                 }
                 
                 break;
                 
            case 2:
                 if(Stein.piecePositions[gridPos[0] + 1][gridPos[1] - 1] == 1) {
                     if (Stein.piecePositions[gridPos[0] + 2][gridPos[1] + 2] == 0) {
                         System.out.println(color + " " + syntax);
                         System.out.println(gridPos[0] + " Links! " + gridPos[1]);
                         return true;
                     }
                 }
             
                 if(Stein.piecePositions[gridPos[0] - 1][gridPos[1] - 1] == 1) {
                     if (Stein.piecePositions[gridPos[0] - 2][gridPos[1] - 2] == 0) {
                         System.out.println(color + " " + syntax);
                         System.out.println(gridPos[0] + " Links! " + gridPos[1]);
                         return true;
                     }
                 }
                 
                 break;
                 
             default:
                System.out.println("Piece syntax error");
        }
        return false;
   }
        
   protected boolean checkField(int[] position)
   {
       return false;
   }
   
    /**
     * Berechnet das zu zeichnende Shape anhand der gegebenen Daten
     * [ Zum Anzeigen der Attributwerte über Inspect muss hier die Sichtbarkeit 
     *  auf public gesetzt werden. ]
     */
    protected Shape gibAktuelleFigur()
    {
        return transform(new Arc2D.Double(0, 0, diameter, diameter, 0 , 360, Arc2D.OPEN));
    }

}

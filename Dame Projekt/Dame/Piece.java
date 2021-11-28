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
    
    /**
     * Erzeuge einen neuen Stuhl mit einer Standardcolor und Standardgroesse
     * an einer Standardposition. (Standardkonstruktor)
     */
    public Piece(boolean isWhite)  {
        pos[0] = 10;
        pos[1] = 10;
        color = (isWhite) ? "blau" : "schwarz";
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

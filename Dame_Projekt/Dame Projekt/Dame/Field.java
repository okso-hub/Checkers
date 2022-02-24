import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/**
 * Ein Piece, der manipuliert werden kann und sich selbst auf einer Leinwand zeichnet.
 * 
 * @author Claus Albowski
 * @version 2.2  (aug 07)
 */
public class Field extends Stein 
{   
    
    int lineCount = 8;
    
    /**
     * Erzeuge einen neuen Stuhl mit einer Standardcolor und Standardgroesse
     * an einer Standardposition. (Standardkonstruktor)
     */
    public Field()  {
        color = "schwarz";
        istSichtbar = false;
    }
    
    /**
     * Berechnet das zu zeichnende Shape anhand der gegebenen Daten
     * [ Zum Anzeigen der Attributwerte über Inspect muss hier die Sichtbarkeit 
     *  auf public gesetzt werden. ]
     */
    protected Shape gibAktuelleFigur()
    {
        GeneralPath lines = new GeneralPath();
        
        for(int i = 0; i < lineCount; i++) {
            Line2D tbLine = new Line2D.Float((400 / lineCount) * i, 0, (400 / lineCount) * i, 400);
            Line2D rlLine = new Line2D.Float(0, (400 / lineCount) * i, 400, (400 / lineCount) * i);
            
            lines.append(rlLine, false);
            lines.append(tbLine, false);
        }
        
        return transform(lines);
    }

}

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.GeneralPath;

public class Zahl extends Stein {
    private int name;
    private String farbe = "blau";
    /**
     * Konstruktor für Objekte der Klasse Zahl
     */
    public Zahl(int pieceNum) {
        // Instanzvariable initialisieren
        name = pieceNum;
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    protected Shape gibAktuelleFigur() {
        // Maße vom Kreis: 40x40
        GeneralPath number = new GeneralPath();
        
        // nummer 1
        GeneralPath lineOne = new GeneralPath();
        lineOne.moveTo(20, 15);
        lineOne.lineTo(40, 0);
        lineOne.lineTo(40, 40);
        // number.append(lineOne, false);
        
        // nummer 3
        Arc2D oben = new Arc2D.Double(15, 10, 15, 15, 90, -180, Arc2D.OPEN);
        Arc2D unten = new Arc2D.Double(15, 25, 15, 15, 90, -180, Arc2D.OPEN);
        // number.append(oben, false);
        // number.append(unten, false);
        
        // nummer 5
        GeneralPath line = new GeneralPath();
        line.moveTo(25, 10);
        line.lineTo(10, 10);
        line.lineTo(10, 25);
        
        Arc2D halbkreis = new Arc2D.Double(7, 25, 15, 15, 90, -180, Arc2D.OPEN);
        // number.append(halbkreis, false);
        // number.append(line, false);
        
        // nummer 7
        GeneralPath path = new GeneralPath();
        path.moveTo(15, 15);
        path.lineTo(30, 15);
        path.lineTo(15, 35);
        // number.append(path, false);
        
        // nummer 9
        Arc2D kreis = new Arc2D.Double(10, 10, 20, 20, 0, 360, Arc2D.OPEN);
        Line2D linie = new Line2D.Double(15, 15, 30, 30);
        
        number.append(kreis, false);
        number.append(linie, false);
        
        return number;
    }
}

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.GeneralPath;

public class Zahl {
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
    public static Shape gibZahl(int num) {
        
        // Maße vom Kreis: 40x40
        GeneralPath number = new GeneralPath();
        
        switch (num) {
            case 0:
                Ellipse2D[] rings = new Ellipse2D[2];
                rings[0] = new Ellipse2D.Float(10, 5, 22.5f, 30);
                rings[1] = new Ellipse2D.Float(13.75f, 7.75f, 15, 22.5f);
                
                for (Ellipse2D ring : rings) {
                    number.append(ring, false);
                }
                break;
            case 1:
                GeneralPath lineOne = new GeneralPath();
                lineOne.moveTo(7.5f, 15);
                lineOne.lineTo(20, 0);
                lineOne.lineTo(20, 40);
                number.append(lineOne, false);
                break;
            case 2:
                Arc2D topRing = new Arc2D.Float(0, 5, 30, 30, 0, 150, Arc2D.OPEN);
                Line2D midLine = new Line2D.Float(30, 15, 5, 30);
                Line2D botLine = new Line2D.Float(5, 30, 30, 30);
                
                number.append(topRing, false);
                number.append(midLine, false);
                number.append(botLine, false);
                break;
            case 3:
                Arc2D oben = new Arc2D.Double(15, 10, 15, 15, 90, -180, Arc2D.OPEN);
                Arc2D unten = new Arc2D.Double(15, 25, 15, 15, 90, -180, Arc2D.OPEN);
                number.append(oben, false);
                number.append(unten, false);
                break;
            case 4:
                Line2D[] lines = new Line2D[3];
                
                lines[0] = new Line2D.Float(25, 18, 0, 18);
                lines[1] = new Line2D.Float(0, 18, 15, 0);
                lines[2] = new Line2D.Float(15, 0, 15, 30);
                
                for (Line2D line : lines) {
                    number.append(line, false);
                }
                break;
            case 5:
                GeneralPath line = new GeneralPath();
                line.moveTo(25, 10);
                line.lineTo(10, 10);
                line.lineTo(10, 25);
                
                Arc2D halbkreis = new Arc2D.Double(7, 25, 15, 15, 90, -180, Arc2D.OPEN);
                number.append(halbkreis, false);
                number.append(line, false);
                break;
            case 6:
                Arc2D botCircle = new Arc2D.Float(5, 20, 20, 20, 0, 360, Arc2D.OPEN);
                Arc2D topp = new Arc2D.Float(5, 5, 20, 30, 90, 120, Arc2D.OPEN);
                
                number.append(botCircle, false);
                number.append(topp, false);
                break;
            case 7:
                GeneralPath path = new GeneralPath();
                path.moveTo(15, 15);
                path.lineTo(30, 15);
                path.lineTo(15, 35);
                number.append(path, false);
                break;
            case 8:
                Arc2D top = new Arc2D.Float(10, 0, 20, 18, 0, 360, Arc2D.OPEN);
                Arc2D bot = new Arc2D.Float(10, 18, 20, 18, 0, 360, Arc2D.OPEN);
        
                number.append(top, false);
                number.append(bot, false);
                break;
            case 9:
                Arc2D kreis = new Arc2D.Double(10, 10, 20, 20, 0, 360, Arc2D.OPEN);
                Line2D linie = new Line2D.Double(30, 25, 20, 45);
        
                number.append(kreis, false);
                number.append(linie, false);
                break;
            case 10:
                // nummer 0
                GeneralPath zero = new GeneralPath();
                
                Ellipse2D[] ringss = new Ellipse2D[2];
                ringss[0] = new Ellipse2D.Float(0 + 15, 0, 22.5f, 30);
                ringss[1] = new Ellipse2D.Float(3.75f + 15f, 3.75f, 15, 22.5f);
                
                for (Ellipse2D ring : ringss) {
                    zero.append(ring, false);
                }
                
                GeneralPath one = new GeneralPath();
                
                // nummer 1
                GeneralPath line_one = new GeneralPath();
                line_one.moveTo(0, 15);
                line_one.lineTo(15, 0);
                line_one.lineTo(15, 30);
                
                number.append(zero, false);
                number.append(line_one, false);
                break;
            case 11:
                GeneralPath firstLine = new GeneralPath();
                firstLine.moveTo(5, 15);
                firstLine.lineTo(25, 0);
                firstLine.lineTo(25, 30);
                GeneralPath secondLine = new GeneralPath();
                secondLine.moveTo(5, 15);
                secondLine.lineTo(35, 0);
                secondLine.lineTo(35, 30);
                
                number.append(firstLine, false);
                number.append(secondLine, false);
                break;
            default:
                System.out.println("Default wird gecalled.");
        }
        
        return number;
    }
}

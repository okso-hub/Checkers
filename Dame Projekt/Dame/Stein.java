import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D; 

/**
 * Abstrakte Klasse Stein - beschreiben Sie hier die Klasse
 * 
 * @author Hey! :)
 * @version (eine Version-Nummer oder ein Datum)
 */
public abstract class Stein
{
    protected int breite = 30;     
    protected int tiefe = 30;
    protected String color;
    protected boolean istSichtbar;
    protected boolean isDead = false;
    
    protected int[] pos = new int[2];
    protected int[]  gridPos = new int[2];
    
    protected boolean[][] isFree = new boolean[8][8];
    public static int[][] piecePositions = new int[8][8];
    
    protected void die()
    {
        isDead = true;
        System.out.println("die() wird gecalled");
        System.out.println(istSichtbar);
        this.zeige();
        this.verberge();
        Main.updatePiecePositions();
        Main.updateScreen();
    }
    
    public static int[][] returnPiecePositions()
    {
        return piecePositions;
    }
    
    public boolean[][] updateBoolean() {
        
        for (int i = 0; i < piecePositions.length; i++) {
            for (int j = 0; j < isFree.length; j++) {
                isFree[i][j] = false;
            }
        }
        
        return isFree;
    }
    
    protected abstract Shape gibAktuelleFigur();
    
    public void zeige() {
        if (!istSichtbar) {
            istSichtbar = true;
            zeichne();
        }
    }
    
    /**
     * Mache dieses Objekt unsichtbar. Wenn es bereits unsichtbar ist, tue nichts.
     */
    public void verberge() {
        loesche(); // "tue nichts" wird in loesche() abgefangen.
        istSichtbar = false;
    }
       
    /**
     * Aendere die color dieses Objektes in 'neuecolor'.
     * Gueltige Angaben sind "rot", "gelb", "blau", "gruen",
     * "lila" und "schwarz".
     */
    public void aenderecolor(String neuecolor) {
        loesche();
        color = neuecolor;
        zeichne();
    }
    
    /**
     * Zeichne dieses Objekt mit seinen aktuellen Werten auf den Bildschirm.
     */
    protected void zeichne() {
        if (istSichtbar) {
            
            pos[0] = gridPos[0] * 50;
            pos[1] = gridPos[1] * 50;
            
            Shape figur = gibAktuelleFigur();
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.zeichne (
              this,           // leinwand kennt das Objekt
              color,          // definiert seine Zeichencolor
              figur);         // definiert seinen grafischen Aspekt
            leinwand.warte(10);
        }
    }
    
    /**
     * Loesche dieses Objekt vom Bildschirm.
     */
    protected void loesche() {
        if (istSichtbar){
            Leinwand leinwand = Leinwand.gibLeinwand();
            leinwand.entferne(this);
        }
    }
    
    protected Shape transform(Shape shape)
    {
        AffineTransform t = new AffineTransform();
        t.translate(pos[0], pos[1]);
        return t.createTransformedShape(shape);
    }
    
}

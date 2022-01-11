import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;

public class Black extends Sides {
    
    // Attribute

    public Black() {
        for(int i = 0; i < pieces.length; i++)
        {
            pieces[i] = new Piece(true);
        }
        
        color = "rot";
    }
    
    public void moveBlack(int pieceNum, int direction) {
        loesche();
        pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction, pieces[pieceNum].gridPos[1] - 1});
        Main.updatePiecePositions();
        zeichne();
    }
    
    public void kill(int[] position) {
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
    
    
    
    public Shape gibAktuelleFigur()
    {
        piecesShape.reset();
        for(Piece piece : pieces)
        {
            piece.resetNewPiece();
            if (!piece.isDead) {
                piecesShape.append(piece.gibAktuelleFigur(), false);
            }
        }
        return transform(piecesShape);
    }
}

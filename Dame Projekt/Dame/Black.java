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
            pieces[i] = new Piece(false);
        }
        
        color = "rot";
    }
    
    public void moveBlack(int pieceNum, int direction) {
        
        if(!pieces[pieceNum].checkKill(direction) && !pieces[pieceNum].checkField(direction)) {
            pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction, pieces[pieceNum].gridPos[1] - 1});
        } else if(pieces[pieceNum].checkKill(direction)) {
            switch (direction) {
                case -1:
                    if (Stein.piecePositions[pieces[pieceNum].gridPos[0] - 1][pieces[pieceNum].gridPos[1] - 1] == 1) {
                        Main.killWhitePiece(new int[]{pieces[pieceNum].gridPos[0] - 1, pieces[pieceNum].gridPos[1] - 1});
                        
                        pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction * 2, pieces[pieceNum].gridPos[1] - 2});
                    } 
                    break;
                case 1:
                    if (Stein.piecePositions[pieces[pieceNum].gridPos[0] + 1][pieces[pieceNum].gridPos[1] - 1] == 1) {
                        Main.killWhitePiece(new int[]{pieces[pieceNum].gridPos[0] + 1, pieces[pieceNum].gridPos[1] - 1});
                        
                        pieces[pieceNum].movePiece(new int[]{pieces[pieceNum].gridPos[0] + direction * 2, pieces[pieceNum].gridPos[1] - 2});
                    }
                    break;
            }
        }
    }
    
    public void moveDame(int a, int b, int c, int d) {
        // leer
    }
    
    public void killOnLine(int gridX, int gridY, int x, int y, int steps) {
        int distance;
        if (gridX > x) {
            distance = gridX - x;
        } else {
            distance = x - gridX;
        }
        
        System.out.println("gridX: " + gridX + ", x: " + x + ", distance: " + distance);
        
        for (int i = 1; i < distance; i++) {
            for (Piece piece : pieces) {
                
                System.out.println("Piece Position check: " + " x was geprüft wird: " + piece.gridPos[0] + (gridX + i) + " y was gerpüft wird: " + piece.gridPos[1] + " " + (gridY - i));
                if (piece.gridPos[0] == (gridX + i) && piece.gridPos[1] == gridY - i) {
                    piece.die();
                }
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

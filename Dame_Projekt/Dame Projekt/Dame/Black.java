import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;

public class Black extends Sides {
    
    // Attribute

    public Black() {
        for(int i = 0; i < pieces.length; i++) {
            pieces[i] = new Piece(false);
        }
        
        color = "schwarz";
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
    
    public void moveDame(int num, int x, int y, int steps) {
        if (pieces[num].checkFieldDame(x, y, steps)) {
            switch(pieces[num].checkKillDame(x, y, steps)) {
                case 0:
                    pieces[num].movePiece(new int[] {pieces[num].gridPos[0] + (x * steps), pieces[num].gridPos[1] + (y * steps)});
                    break;
                case 1:
                    int gridX = pieces[num].gridPos[0];
                    int gridY = pieces[num].gridPos[1];
                    
                    pieces[num].movePiece(new int[] {pieces[num].gridPos[0] + (x * steps), pieces[num].gridPos[1] + (y * steps)});
                    Main.killOnLine(gridX, gridY, (x * steps) + gridX, (y * steps) + gridY, steps, 1);
                    break;
                case 2:
                    break;
            }
        }
    }
    
    public Shape gibAktuelleFigur() {
        piecesShape.reset();
        for(Piece piece : pieces) {
            piece.resetNewPiece();
            if (!piece.isDead) {
                piecesShape.append(piece.gibAktuelleFigur(), false);
            }
        }
        return transform(piecesShape);
    }
}

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class Main 
{
    public static White wPieces;
    public static Black bPieces;
    public static Field field;
    
    public static String returnGame() {
        String game = "";
        int index = 0;
        for (Piece piece: wPieces.pieces) {
            if (index < 10) {
                game += "0";
            }
            game += index;
            game += piece.gridPos[0];
            game += piece.gridPos[1];
            game += piece.isDead ? "1" : "0";
            // game += isDame;
            game += piece.syntax;
            index++;
        }
        
        index = 0;
        
        for (Piece piece: bPieces.pieces) {
            if (index < 10) {
                game += "0";
            }
            game += index;
            game += piece.gridPos[0];
            game += piece.gridPos[1];
            game += piece.isDead ? "1" : "0";
            // game += isDame;
            game += piece.syntax;
            index++;
        }
        return game;
    }
    
    public static void saveGame() {
        JFrame frame = new JFrame();
        File dir;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Choose directory for saving the game");
        
        int showSaveDialog = fileChooser.showSaveDialog(frame);
        System.out.println("Ganz oben in der Methode");
        
        if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
          dir = fileChooser.getSelectedFile();
          File file = new File(dir, "game_content.txt");
          try {
              FileWriter fw = new FileWriter(file);
              fw.write(returnGame());
              fw.close();
          } catch(IOException ex) {
              ex.printStackTrace();
          }
        }
    }
    
    public static void loadGame() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose saved game");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        File file;
        String game;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          file = fileChooser.getSelectedFile();
          try {
              Scanner scanner = new Scanner(file);
              game = scanner.nextLine();
              // System.out.println("Pieces length: " + wPieces.pieces.length);
              char[] gameInfo = game.toCharArray();
              for (int i = 0; i < (wPieces.pieces.length * 2); i++) {
                  // System.out.println("i: " + i);
                  // System.out.println("gameInfo[i]: " + gameInfo[i] + " gameInfo[i * 6 + 5]: " + gameInfo[i * 6 + 5]);
                  int currPiece = Integer.parseInt(String.valueOf(new char[] {gameInfo[i * 6], gameInfo[i * 6 + 1]}));
                  // System.out.println("currPiece: " + currPiece);
                  if (gameInfo[i * 6 + 5] == '1') {
                      // System.out.println("Game info: " + gameInfo[i * 6 + 2]);
                      // System.out.println("Game info: " + gameInfo[i * 6 + 3]);
                      wPieces.pieces[currPiece].gridPos[0] = gameInfo[i * 6 + 2] - '0';
                      wPieces.pieces[currPiece].gridPos[1] = gameInfo[i * 6 + 3] - '0';
                      wPieces.pieces[currPiece].isDead = (gameInfo[i * 6 + 4]) == '1' ? true : false;
                      // System.out.println("White piece: " + i);
                      updatePiecePositions();
                      updateScreen();
                  }
                  
                  if (gameInfo[i * 6 + 5] == '2') {
                      // System.out.println("Game info: " + gameInfo[i * 6 + 2]);
                      // System.out.println("Game info: " + gameInfo[i * 6 + 3]);
                      bPieces.pieces[currPiece].gridPos[0] = gameInfo[i * 6 + 2] - '0';
                      bPieces.pieces[currPiece].gridPos[1] = gameInfo[i * 6 + 3] - '0';
                      bPieces.pieces[currPiece].isDead = (gameInfo[i * 6 + 4]) == '1' ? true : false;
                      // System.out.println("Black piece: " + i);
                      updatePiecePositions();
                      updateScreen();
                  }
                  updatePiecePositions();
                  updateScreen();
              }
              updatePiecePositions();
          } catch(FileNotFoundException fnfe) {
              System.out.println("An error occured.");
          } 
        }
        updatePiecePositions();
        updateScreen();
    }
    
    
    public static void main(String[] args) {
    
        wPieces = new White();
        bPieces = new Black();
        field = new Field();
        
        wPieces.positionWhitePieces();
        wPieces.zeige();
        
        bPieces.positionBlackPieces();
        bPieces.zeige();
        
        field.zeige();
        
        updatePiecePositions();
    }
    
    public static void moveWhite(int pieceNum, int direction) {
        wPieces.moveWhite(pieceNum, direction);
        updatePiecePositions();
        checkDame();
        updateScreen();
    }
    
    public static void moveBlack(int pieceNum, int direction) {
        bPieces.moveBlack(pieceNum, direction);
        updatePiecePositions();
        checkDame();
        updateScreen();
    }
    
    public static void moveWhiteDame(int pieceNum, int xDirection, int yDirection, int steps) {
        wPieces.moveDame(pieceNum, xDirection, yDirection, steps);
        updatePiecePositions();
        checkDame();
        updateScreen();
    }
    
    public static void moveBlackDame(int pieceNum, int xDirection, int yDirection, int steps) {
        bPieces.moveDame(pieceNum, xDirection, yDirection, steps);
        updatePiecePositions();
        checkDame();
        updateScreen();
    }
    
    public static void updateScreen() {
        bPieces.loesche();
        wPieces.loesche();
        
        bPieces.zeichne();
        wPieces.zeichne();
    }
    
    public static void returnDead() {
        bPieces.getPiecePosition();
    }
    
    public static void killBlackPiece(int[] position) {
        bPieces.kill(position);
    }
    
    public static void killWhitePiece(int[] position) {
        wPieces.kill(position);
    }
    
    public static void killOnLine(int gridX, int gridY, int x, int y, int steps) {
        bPieces.killOnLine(gridX, gridY, x, y, steps);
    }
    
    public static boolean debug2 (int x, int y, int steps)
    {
        return wPieces.pieces[11].checkFieldDame(x, y, steps);
    }
    
    public static void updatePiecePositions() {
        for (int i = 0; i < Stein.piecePositions.length; i++) {
            for (int j = 0; j < Stein.piecePositions.length; j++) {
                Stein.piecePositions[i][j] = bPieces.getPiecePosition()[i][j] + wPieces.getPiecePosition()[i][j];
            }
        }
    }
    
    public static void checkDame() {
        for (Piece piece: wPieces.pieces) {
            if (piece.checkDame()) {
                piece.turnDame();
            }
        }
        
        for (Piece piece: bPieces.pieces) {
            if (piece.checkDame()) {
                piece.turnDame();
            }
        }
    }
}
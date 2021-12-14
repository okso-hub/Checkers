public class Main 
{
    public static White wPieces;
    public static Black bPieces;
    public static Field field;
    
    
    public static void main(String[] args)
    {
    
        wPieces = new White();
        bPieces = new Black();
        field = new Field();
        
        wPieces.positionWhitePieces();
        wPieces.zeige();
        
        bPieces.positionBlackPieces();
        bPieces.zeige();
        
        field.zeige();
        
        updatePiecePositions();
        System.out.println(Stein.piecePositions);
        // Stein.piecePositions = bPieces.getPiecePosition() + wPieces.getPiecePosition();
    }
    
    public static void moveWhite(int num, int direction)
    {
        wPieces.moveWhite(num, direction);
    }
    
    public static boolean debug()
    {
         return wPieces.debug();
    }
    
    public static void moveBlack(int num, int direction)
    {
        bPieces.moveBlack(num, direction);
    }
    
    public static void updateArrayPosition()
    {
        // leer
    }
    
    public static void killOne()
    {
// //         bPieces.kill(new int[]^^^^^^^^^^^^^^^^^^^^)
    }
    
    public static void killBlackPiece(int[] position) {
        bPieces.kill(position);
    }
    
    public static void updatePiecePositions() {
        for (int i = 0; i < Stein.piecePositions.length; i++) {
            for (int j = 0; j < Stein.piecePositions.length; j++) {
                Stein.piecePositions[i][j] = bPieces.getPiecePosition()[i][j] + wPieces.getPiecePosition()[i][j];
            }
        }
    }
}
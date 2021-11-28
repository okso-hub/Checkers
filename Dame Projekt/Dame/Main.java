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
    }
    
    public static void moveWhite(int num, int direction)
    {
        wPieces.moveWhite(num, direction);
    }
    
    public static void moveBlack(int num, int direction)
    {
        bPieces.moveBlack(num, direction);
    }

}
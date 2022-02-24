
/**
 * Beschreiben Sie hier die Klasse PlayGame.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PlayGame {
    
    
    public static void bewegeWeiss(int nummer, int richtung) {
        Main.moveWhite(nummer, richtung);
    }
    
    public static void bewegeSchwarz(int nummer, int richtung) {
        Main.moveBlack(nummer, richtung);
    }
    
    public static void bewegeWeisseDame(int steinNummer, int xRichtung, int yRichtung, int schritte) {
        Main.moveWhiteDame(steinNummer, xRichtung, yRichtung, schritte);
    }
    
    public static void bewegeSchwarzeDame(int steinNummer, int xRichtung, int yRichtung, int schritte) {
        Main.moveBlackDame(steinNummer, xRichtung, yRichtung, schritte);
    }
    
    public static void speichern() {
        Main.saveGame();
    }
    
    public static void laden() {
        Main.loadGame();
    }
    
    public static void spielStart() {
        MainMenu menu = new MainMenu();
    }
}

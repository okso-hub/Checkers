import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;

public class Piece extends Stein 
{   
    
    protected int diameter;
    protected int syntax;
    protected boolean isDame;
    
    /**
     * Erzeuge einen neuen Stuhl mit einer Standardcolor und Standardgroesse
     * an einer Standardposition. (Standardkonstruktor)
     */
    public Piece(boolean isWhite)  {
        pos[0] = 10;
        pos[1] = 10;
        color = (isWhite) ? "blau" : "schwarz";
        syntax = (isWhite) ? 1 : 2;
        isDame = false;
        istSichtbar = false;
        diameter = 40;
    }
    
    protected void movePiece(int[] newPos) {
        loesche();
        System.out.println(newPos[0] + "PERFecto");
        System.out.println(newPos[1] + "perfextro");
        gridPos[0] = newPos[0];
        gridPos[1] = newPos[1];
        
        resetNewPiece();
        
        zeichne();
    }
    
    public void resetNewPiece() {
        pos[0] = (gridPos[0] * 50) - diameter / 2;
        pos[1] = (gridPos[1] * 50) - diameter / 2;
        pos[0] = pos[0] + 25;
        pos[1] = pos[1] + 25;
    }

    protected boolean checkKill(int direction) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try {
            switch (syntax) {
                case 1:
                    
                     switch (direction) {
                         case 1:
                             System.out.println(Stein.piecePositions[gridPos[0] + 1][gridPos[1] + 1]);
                             if(Stein.piecePositions[gridPos[0] + 1][gridPos[1] + 1] == 2) {
                                 System.out.println("Nach unten rechts gibt es einen gegner!");
                                 if (Stein.piecePositions[gridPos[0] + 2][gridPos[1] + 2] == 0) {
                                     System.out.println(gridPos[0] + " Rechts! " + gridPos[1]);
                                     return true;
                                 }
                             }
                             break;
                         case -1:
                             if(Stein.piecePositions[gridPos[0] - 1][gridPos[1] + 1] == 2) {
                                 System.out.println("Nach unten links gibt es einen gegner!");
                                 if (Stein.piecePositions[gridPos[0] - 2][gridPos[1] + 2] == 0) {
                                     System.out.println(gridPos[0] + " Links! " + gridPos[1]);
                                     return true;
                                 }
                             }
                             break;
                     }
                     break;
                     
                case 2:
                     
                     switch (direction) {
                         case 1:
                             if(Stein.piecePositions[gridPos[0] + 1][gridPos[1] - 1] == 1) {
                                 if (Stein.piecePositions[gridPos[0] + 2][gridPos[1] - 2] == 0) {
                                     System.out.println(color + " " + syntax);
                                     System.out.println(gridPos[0] + " Links! " + gridPos[1]);
                                     return true;
                                 }
                             }
                         case -1:
                             if(Stein.piecePositions[gridPos[0] - 1][gridPos[1] - 1] == 1) {
                                 if (Stein.piecePositions[gridPos[0] - 2][gridPos[1] - 2] == 0) {
                                     System.out.println(color + " " + syntax);
                                     System.out.println(gridPos[0] + " Links! " + gridPos[1]);
                                     return true;
                                 }
                             }
                     }
                     break;
                     
                 default:
                    System.out.println("Piece syntax error");
            } 
        } catch(ArrayIndexOutOfBoundsException outOfWindow) {
            return false;
        }
        return false;
   }
        
   protected boolean checkField(int direction) {
       try {
           switch (syntax) {
               
               case 1:
                   
                     switch (direction) {
                         case 1:
                             System.out.println("Case 1 wird ausgefuehrt");
                             if (Stein.piecePositions[gridPos[0] + 1][gridPos[1] + 1] != 0) {
                                 if (Stein.piecePositions[gridPos[0] + 2][gridPos[1] + 2] != 0) {
                                     return true;
                                 }
                             } else if (Stein.piecePositions[gridPos[0] + 1][gridPos[1] + 1] == 1) {
                                 return true;
                             } else {
                                 return false;
                             }
                             break;
                         case -1:
                             System.out.println("Case 2 wird ausgefuehrt");
                             if(Stein.piecePositions[gridPos[0] - 1][gridPos[1] + 1] != 0) {
                                 if (Stein.piecePositions[gridPos[0] - 2][gridPos[1] + 2] != 0) {
                                     return true;
                                 }
                             }  else if (Stein.piecePositions[gridPos[0] - 1][gridPos[1] + 1] == 1) {
                                 return true;
                             } else if (2==2) {
                                 return false;
                             } else {
                                 return false;
                             }
                             break;
                     }
                     break;
               
               case 2:
                    switch (direction) {
                         case 1:
                             if(Stein.piecePositions[gridPos[0] + 1][gridPos[1] - 1] != 0) {
                                 if (Stein.piecePositions[gridPos[0] + 2][gridPos[1] - 2] != 0) {
                                     return true;
                                 }
                             } else if (Stein.piecePositions[gridPos[0] + 1][gridPos[1] - 1] == 2) {
                                 return true;
                             } else {
                                return false;
                             }
                         case -1:                     
                             if(Stein.piecePositions[gridPos[0] - 1][gridPos[1] - 1] != 0) {
                                 if (Stein.piecePositions[gridPos[0] - 2][gridPos[1] - 2] != 0) {
                                     return true;
                                 }
                             } else if (Stein.piecePositions[gridPos[0] - 1][gridPos[1] - 1] == 2) {
                                 return true;
                             } else {
                                 return false;
                             }
                    }
                    break;
               default:
                    System.out.println("Piece syntax error");
               
           }
       } catch(ArrayIndexOutOfBoundsException outOfWindow) {
           return true;
       }
       return false;
   }
   
   protected boolean checkDame() {
       switch(syntax) {
           case 1:
               if (gridPos[1] == 7) {
                   return true;
               }
               break;
           case 2:
               if (gridPos[1] == 0) {
                   return true;
               }
               break;
       }
       return false;
   }
   
   protected boolean checkFieldDame(int x, int y, int steps) {
       int current;
       for (int i = 1; i <= steps; i++) {
           try {
               current = Stein.piecePositions[gridPos[0] + (i * x)][gridPos[1] + (i * y)]; 
               if (current == syntax) {
                   return false;
               }
           } catch(Exception e) {
               return false;
           }
       }
       return true;
   }
   
   protected int checkKillDame(int x, int y, int steps) {
       // 0 -> Feld frei (keine Gegner)
       // 1 -> einer oder mehr Gegner, die getötet werden können
       // 2 -> Gegner stehen hintereinander (kann nicht getötet werden)
       int result = 0;
       boolean foundEnemy = false;
       int current;
       for (int i = 1; i <= steps; i++) {
           try {
               current = Stein.piecePositions[gridPos[0] + (i * x)][gridPos[1] + (i * y)];
               if (current != syntax && current != 0) {
                   int next = Stein.piecePositions[gridPos[0] + (i * x) + x][gridPos[1] + (i * y) + y];
                   switch (next) {
                       case 0:
                            foundEnemy = true;
                       default:
                            result = 2;
                            foundEnemy = false;
                            break;
                   } 
               } 
           } catch(Exception e) {
               result = 2;
               foundEnemy = false;
           }
       }
       if (foundEnemy) {
           return 1;
       } 
       return result;
   }
   
   protected void turnDame() {
       isDame = true;
   }
    
   protected Shape gibAktuelleFigur() {
       GeneralPath figur = new GeneralPath();
       
       Arc2D kreis = new Arc2D.Double(0, 0, diameter, diameter, 0 , 360, Arc2D.OPEN);
       Arc2D kleinerKreis = new Arc2D.Double(0, 0, diameter / 2, diameter / 2, 0, 360, Arc2D.OPEN);
       
       figur.append(kreis, false);
       if (isDame) {
           figur.append(kleinerKreis, false);
       }
       
       return transform(figur);
   }

}

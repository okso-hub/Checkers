import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class GameMenu implements ActionListener{
    
    private JFrame frame;
    private JLabel label;
    private JLabel[] dameText = new JLabel[5];
    private JButton[] buttons = new JButton[6];
    private JTextField[] dameInput = new JTextField[9];
    private JTextField[] normInput = new JTextField[4];
    
    public GameMenu() {
        frame = new JFrame();
        
        dameText[0] = new JLabel("Figuren Bewegen");
        dameText[1] = new JLabel("Weisse Figur Bewegen");
        dameText[2] = new JLabel("Schwarze Figur Bewegen");
        dameText[3] = new JLabel("Weisse Dame Bewegen");
        dameText[4] = new JLabel("Schwarze Dame Bewegen");
        
        for (int i = 1; i < 5; i++) {
            dameText[i].setBounds(10, 0 + i*30, 30, 10);
            dameText[i].setSize(250, 20);
            frame.add(dameText[i]);
        }
        
        for(int i = 0; i < normInput.length; i++)
        {
            if(i < 2)
            {
                normInput[i] = new JTextField();
                normInput[i].setBounds(210 + 50 * i, 1 * 30, 30, 10);
                normInput[i].setSize(50, 20);
                frame.add(normInput[i]);
            }
            else 
            {          
                normInput[i] = new JTextField();
                normInput[i].setBounds(210 + 50 * (i - 2), 2 * 30, 30, 10);
                normInput[i].setSize(50, 20);
                frame.add(normInput[i]);
            }
        }
        
        for(int i = 0; i < dameInput.length; i++)
        {          
            if(i < 4)
            {
                dameInput[i] = new JTextField();
                dameInput[i].setBounds(210 + 50 * i, 3 * 30, 30, 10);
                dameInput[i].setSize(50, 20);
                frame.add(dameInput[i]);
            }
            else 
            {          
                dameInput[i] = new JTextField();
                dameInput[i].setBounds(210 + 50 * (i - 4), 4 * 30, 30, 10);
                dameInput[i].setSize(50, 20);
                frame.add(dameInput[i]);
            }
        }
        
        for(int i = 0; i < 6; i++)
        {
            buttons[i] = new JButton("");
            buttons[i].setBounds(210 + 250, (i + 1) * 30, 30, 30);
            buttons[i].setSize(60, 20);
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }
        
        buttons[4].setText("Save");
        buttons[4].setBounds(210 + 230, 5 * 30, 30, 30);
        buttons[4].setSize(100, 35);
        
        buttons[5].setVisible(false);
        dameInput[8].setVisible(false);
        
        frame.setSize(600, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Spiel Menü");
        frame.setVisible(true);
        
        // for (JTextField field : input) {
            // field = new JTextField();
            // frame.add(field);
        // }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            Main.moveWhite(Integer.parseInt(normInput[0].getText()), Integer.parseInt(normInput[1].getText()));
            normInput[0].setText("");
            normInput[1].setText("");
        } else if(e.getSource() == buttons[1]) {
            Main.moveBlack(Integer.parseInt(normInput[2].getText()), Integer.parseInt(normInput[3].getText()));
            normInput[2].setText("");
            normInput[3].setText("");
        }
          else if(e.getSource() == buttons[2]) {
            Main.moveWhiteDame(Integer.parseInt(dameInput[0].getText()), 
            Integer.parseInt(dameInput[1].getText()), 
            Integer.parseInt(dameInput[2].getText()), 
            Integer.parseInt(dameInput[3].getText()));
            dameInput[0].setText("");
            dameInput[1].setText("");
            dameInput[2].setText("");
            dameInput[3].setText("");
        }
        else if(e.getSource() == buttons[3]) {
            Main.moveBlackDame(Integer.parseInt(dameInput[4].getText()), 
            Integer.parseInt(dameInput[5].getText()), 
            Integer.parseInt(dameInput[6].getText()), 
            Integer.parseInt(dameInput[7].getText()));
            dameInput[4].setText("");
            dameInput[5].setText("");
            dameInput[6].setText("");
            dameInput[7].setText("");
        }
        else if(e.getSource() == buttons[4]) {
            Main.saveGame();
        }
    }
}

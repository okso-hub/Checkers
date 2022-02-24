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
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class MainMenu implements ActionListener {
    private JButton start;
    private JButton load;
    private JButton nothing;
    private JFrame frame;
    
    public MainMenu() {
        JLabel label = new JLabel("DAME!");
        
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Start Menü");
        frame.setVisible(true);
        // frame.setLayout(new FlowLayout());
        
        label.setFont(new Font("SansSerif", Font.PLAIN, 85));
        
        label.setBounds(60, 50, 100, 100);
        label.setSize(700, 100);
        frame.add(label);
        
        start = new JButton("Starte Spiel");
        start.addActionListener(this);
        start.setBounds(130, 250, 100, 50);
        frame.add(start);
        
        load = new JButton("Lade Spiel");
        load.addActionListener(this);
        load.setBounds(130, 303, 100, 50);
        frame.add(load);
        
        nothing = new JButton("");
        frame.add(nothing);
        nothing.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        Main.main(new String[0]);
        if (e.getSource() == this.start) {
            frame.setVisible(false); 
            frame.dispose();
        } else {
            Main.loadGame();
            frame.setVisible(false); 
            frame.dispose();
        }
    }
}

package Mini;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WAPFrame extends JFrame{
    WAPFrame(){
        JFrame newFrame = new JFrame("Clipping Tutorial -> Polygon -> Weiler-Atherton Polygon Clipping Algorithm");
        newFrame.setSize(1200, 800);
        newFrame.setLayout(null);

        JLabel label = new JLabel("Weiler-Atherton Polygon Clipping Algorithm");
        label.setBounds(500, 50, 500, 30);
       

        newFrame.add(label);
        newFrame.setVisible(true);
    }
    
}

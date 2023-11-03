package Mini;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HomeFrame extends JFrame{
    HomeFrame(){

        this.setSize(1200,800); // Set a window size
       
        this.setTitle("Clipping Tutorial");
        ImageIcon image = new ImageIcon("C:\\Users\\gound\\Downloads\\Frame.jpg");
        JLabel label = new JLabel();
        label.setText("Choose type of clipping :");
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        
        label.setIconTextGap(50);

        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(0, 0, 1200, 400);

        JMenuBar menuBarL = new JMenuBar();
        JMenuBar menuBarP = new JMenuBar();
        
        // Create a menu
        JMenu LineMenu = new JMenu("Line Clipping");
        JMenu PolygonMenu = new JMenu("Polygon Clipping");
        menuBarL.add(LineMenu);
        menuBarP.add(PolygonMenu);

         // Create menu items
        JMenuItem CSLItem = new JMenuItem("Cohen Sutherland Line Clipping Algorithm");
        JMenuItem LBLItem = new JMenuItem("Liang-Barsky Line Clipping Algorithm");
        JMenuItem SHPItem = new JMenuItem("Sutherland-Hodgeman Polygon Clipping Algorithm");
        JMenuItem WAPItem = new JMenuItem("Weiler-Atherton Polygon Clipping Algorithm");

       

         // Add menu items to the "File" menu
        LineMenu.add(CSLItem);
        LineMenu.add(LBLItem);

        PolygonMenu.add(SHPItem);
        PolygonMenu.add(WAPItem);

        // Set the location of the menu bar (centered)
        menuBarL.setBounds(300, 200, menuBarL.getPreferredSize().width, menuBarL.getPreferredSize().height);

        menuBarP.setBounds(800, 200, menuBarP.getPreferredSize().width, menuBarP.getPreferredSize().height);
 
         // Add the menu bar to the frame
        this.add(menuBarL);
        this.add(menuBarP);
        this.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLayout(null);
        this.setVisible(true); //Make a frame visiable

        CSLItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new window when the menu item is clicked
               CSLFrame csl = new CSLFrame();
               dispose();
               
            }
        });
        LBLItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new window when the menu item is clicked
               LBLFrame lbl = new LBLFrame();
               dispose();
            }
        });
        SHPItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new window when the menu item is clicked
               SHPFrame shp = new SHPFrame();
               dispose();
            }
        });

        WAPItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new window when the menu item is clicked
               WAPFrame wap = new WAPFrame();
               dispose();
            }
        });

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\gound\\Downloads\\Icon.jpg");
        this.setIconImage(imageIcon.getImage());
   
    }
    
}

package Mini;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class HomeFrame extends JFrame{
    HomeFrame(){

        this.setSize(1200,800); // Set a window size
        
        this.setLayout(new FlowLayout());
       
        this.setTitle("Clipping Tutorial");
        ImageIcon image = new ImageIcon("C:\\Users\\gound\\Downloads\\Frame.jpg");
        JLabel label = new JLabel();
        label.setText("<html>" +"Basic Concepts of Clipping(Don't Know about anything?):-<br><br><br><br><br>"+"Choose type of clipping :</html>");

      
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        
        label.setIconTextGap(95);
     
        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(0, 0, 1200, 400);

        JButton openButton = new JButton("Open PDF");
        openButton.setBounds(800, 200, 100, 30);
        this.add(openButton);

        JMenuBar menuBarL = new JMenuBar();
        JMenuBar menuBarP = new JMenuBar();
        
        // Create a menu
        JMenu LineMenu = new JMenu("Line Clipping");
        menuBarL.add(LineMenu);
       

         // Create menu items
        JMenuItem CSLItem = new JMenuItem("Cohen Sutherland Line Clipping Algorithm");
        JMenuItem LBLItem = new JMenuItem("Liang-Barsky Line Clipping Algorithm");

         // Add menu items to the "File" menu
        LineMenu.add(CSLItem);
        LineMenu.add(LBLItem);


        // Set the location of the menu bar (centered)
        menuBarL.setBounds(650, 285, menuBarL.getPreferredSize().width, menuBarL.getPreferredSize().height);

     
 
         // Add the menu bar to the frame
        this.add(menuBarL);
       
        this.add(label);
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLayout(null);
        this.setVisible(true); //Make a frame visiable

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPDF();
            }
        });
    

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
       

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\gound\\Downloads\\Icon.jpg");
        this.setIconImage(imageIcon.getImage());
   
    }
    

 private static void openPDF() {
        try {
            File pdfFile = new File("C:\\Users\\gound\\Downloads\\clipping.pdf");
            if (pdfFile.exists()) {
                // Define the PDF viewer based on the platform
                String os = System.getProperty("os.name").toLowerCase();
                String pdfViewerCommand;

                if (os.contains("win")) {
                    pdfViewerCommand = "rundll32 url.dll,FileProtocolHandler " + pdfFile.getAbsolutePath();
                } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                    pdfViewerCommand = "xdg-open " + pdfFile.getAbsolutePath();
                } else {
                    // Handle unsupported platform
                    JOptionPane.showMessageDialog(null, "Platform not supported.");
                    return;
                }

                // Execute the PDF viewer command
                Process process = Runtime.getRuntime().exec(pdfViewerCommand);
                process.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "PDF file does not exist.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

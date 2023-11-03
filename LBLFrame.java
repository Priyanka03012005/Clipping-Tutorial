package Mini;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LBLFrame extends JFrame{
    LBLFrame(){
        JFrame newFrame = new JFrame("Clipping Tutorial -> Line -> Liang-Barsky Line Clipping Algorithm");
        newFrame.setSize(1200, 800);
        newFrame.setLayout(null);

        JLabel label = new JLabel("Liang-Barsky Line Clipping Algorithm");
        label.setBounds(500, 50, 500, 30);

        JLabel labell = new JLabel("Enter the Line Co ordinates : \n (0 <= X-axis <= 1200) & (0 <= Y-axis <= 800)");
        labell.setBounds(200, 100, 500, 30);

        JLabel labelx1 = new JLabel("x1 = ");
        labelx1.setBounds(400, 130, 500, 30);

        JTextField textFieldx1 = new JTextField();
        textFieldx1.setBounds(450,135,50,20);
        textFieldx1.setBackground(Color.WHITE);

        JLabel labely1 = new JLabel("y1 = ");
        labely1.setBounds(600, 130, 500, 30);

        JTextField textFieldy1 = new JTextField();
        textFieldy1.setBounds(650,135,50,20);
        textFieldy1.setBackground(Color.WHITE);

        JLabel labelx2 = new JLabel("x2 = ");
        labelx2.setBounds(400, 160, 500, 30);

        JTextField textFieldx2 = new JTextField();
        textFieldx2.setBounds(450,165,50,20);
        textFieldx2.setBackground(Color.WHITE);

        JLabel labely2 = new JLabel("y2 = ");
        labely2.setBounds(600, 160, 500, 30);

        JTextField textFieldy2 = new JTextField();
        textFieldy2.setBounds(650,165,50,20);
        textFieldy2.setBackground(Color.WHITE);

        JLabel labelW = new JLabel("Enter the Window Co ordinates : \n (100 <= X-axis <= 1200) & (100 <= Y-axis <= 800)");
        labelW.setBounds(200, 200, 500, 30);

        JLabel labelWxmin = new JLabel("Wxmin = ");
        labelWxmin.setBounds(372, 230, 500, 30);

        JTextField textFieldWxmin = new JTextField();
        textFieldWxmin.setBounds(450,235,50,20);
        textFieldWxmin.setBackground(Color.WHITE);

        JLabel labelWymin = new JLabel("Wymin = ");
        labelWymin.setBounds(572, 230, 500, 30);

        JTextField textFieldWymin = new JTextField();
        textFieldWymin.setBounds(650,235,50,20);
        textFieldWymin.setBackground(Color.WHITE);

        JLabel labelWxmax = new JLabel("Wxmax = ");
        labelWxmax.setBounds(372, 260, 500, 30);

        JTextField textFieldWxmax = new JTextField();
        textFieldWxmax.setBounds(450,265,50,20);
        textFieldWxmax.setBackground(Color.WHITE);

        JLabel labelWymax = new JLabel("Wymax = ");
        labelWymax.setBounds(572, 260, 500, 30);

        JTextField textFieldWymax = new JTextField();
        textFieldWymax.setBounds(650,265,50,20);
        textFieldWymax.setBackground(Color.WHITE);

        newFrame.add(label);
        newFrame.add(labell);
        newFrame.add(labelx1);
        newFrame.add(textFieldx1);
        newFrame.add(labely1);
        newFrame.add(textFieldy1);
        newFrame.add(labelx2);
        newFrame.add(textFieldx2);
        newFrame.add(labely2);
        newFrame.add(textFieldy2);

        newFrame.add(labelW);
        newFrame.add(labelWxmin);
        newFrame.add(textFieldWxmin);
        newFrame.add(labelWymin);
        newFrame.add(textFieldWymin);
        newFrame.add(labelWxmax);
        newFrame.add(textFieldWxmax);
        newFrame.add(labelWymax);
        newFrame.add(textFieldWymax);

        JButton OutputButton = new JButton("Output");
        OutputButton.setBounds(800, 500, 150, 30); // Set the button's position and size
        newFrame.add(OutputButton);
        OutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new window when the button is clicked
                try {
                    int x1 = Integer.parseInt(textFieldx1.getText());
                    int y1 = Integer.parseInt(textFieldy1.getText());
                    int x2 = Integer.parseInt(textFieldx2.getText());
                    int y2 = Integer.parseInt(textFieldy2.getText());
                    int Wxmin = Integer.parseInt(textFieldWxmin.getText());
                    int Wymin = Integer.parseInt(textFieldWymin.getText());
                    int Wxmax = Integer.parseInt(textFieldWxmax.getText());
                    int Wymax = Integer.parseInt(textFieldWymax.getText());
                    LBLBeforeClip lbllBeforeClip = new LBLBeforeClip(x1,y1,x2,y2,Wxmin,Wymin,Wxmax,Wymax);
                    newFrame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(LBLFrame.this, "Please enter valid integer values.");
                }
            }
        });

        
        JButton HomeButton = new JButton("Home");
        HomeButton.setBounds(300, 500, 150, 30); // Set the button's position and size
        newFrame.add(HomeButton);

        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               HomeFrame hf = new HomeFrame();
               newFrame.dispose();
            }
        });

        newFrame.add(label);
        newFrame.setVisible(true);
    }
    
}

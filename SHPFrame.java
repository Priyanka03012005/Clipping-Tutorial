package Mini;

import java.awt.*;

import javax.print.attribute.standard.Sides;
import javax.swing.*;
import java.awt.event.*;

public class SHPFrame extends JFrame{
    public int sides;

    public JTextField[] textFieldsx,textFieldsy;
    private JButton createButton;
     
    SHPFrame(){
        JFrame newFrame = new JFrame("Clipping Tutorial -> Polygon -> Sutherland-Hodgeman Polygon Clipping Algorithm");
        newFrame.setSize(1200, 800);
        newFrame.setLayout(null);

        JLabel label = new JLabel("Sutherland-Hodgeman Polygon Clipping Algorithm");
        label.setBounds(500, 50, 500, 30);

        newFrame.add(label);
        
        JLabel labelW = new JLabel("Enter the Window Co ordinates : \n (100 <= X-axis <= 1200) & (100 <= Y-axis <= 800)");
        labelW.setBounds(200, 100, 500, 30);

        JLabel labelWxmin = new JLabel("Wxmin = ");
        labelWxmin.setBounds(400, 130, 500, 30);

        JTextField textFieldWxmin = new JTextField();
        textFieldWxmin.setBounds(500,135,50,20);
        textFieldWxmin.setBackground(Color.WHITE);

        JLabel labelWymin = new JLabel("Wymin = ");
        labelWymin.setBounds(600, 130, 500, 30);

        JTextField textFieldWymin = new JTextField();
        textFieldWymin.setBounds(700,135,50,20);
        textFieldWymin.setBackground(Color.WHITE);

        JLabel labelWxmax = new JLabel("Wxmax = ");
        labelWxmax.setBounds(400, 160, 500, 30);

        JTextField textFieldWxmax = new JTextField();
        textFieldWxmax.setBounds(500,165,50,20);
        textFieldWxmax.setBackground(Color.WHITE);

        JLabel labelWymax = new JLabel("Wymax = ");
        labelWymax.setBounds(600, 160, 500, 30);

        JTextField textFieldWymax = new JTextField();
        textFieldWymax.setBounds(700,165,50,20);
        textFieldWymax.setBackground(Color.WHITE);

        JLabel labelsides = new JLabel("Enter the X and Y Co-ordinate points :");
        labelsides.setBounds(200, 200, 500, 30);

        JTextField textFieldsides = new JTextField();
        textFieldsides.setBounds(380,210,50,20);
        textFieldsides.setBackground(Color.WHITE);

        newFrame.add(labelW);
        newFrame.add(labelWxmin);
        newFrame.add(textFieldWxmin);
        newFrame.add(labelWymin);
        newFrame.add(textFieldWymin);
        newFrame.add(labelWxmax);
        newFrame.add(textFieldWxmax);
        newFrame.add(labelWymax);
        newFrame.add(textFieldWymax);

        newFrame.add(labelsides);
       // newFrame.add(textFieldsides);

       int sides = promptUserForNumberOfFields();

        JButton OutputButton = new JButton("Output");
        OutputButton.setBounds(800, 500, 150, 30); // Set the button's position and size
        newFrame.add(OutputButton);
        OutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new window when the button is clicked
                try {
                    
                    int Wxmin = Integer.parseInt(textFieldWxmin.getText());
                    int Wymin = Integer.parseInt(textFieldWymin.getText());
                    int Wxmax = Integer.parseInt(textFieldWxmax.getText());
                    int Wymax = Integer.parseInt(textFieldWymax.getText());
                    JTextField[] textFieldsx = new JTextField[sides];
                    JTextField[] textFieldsy = new JTextField[sides];

                    for (int i = 0; i < sides; i++) {
                        textFieldsx[i] = new JTextField(10);
                        textFieldsx[i].setText(textFieldsx[i].getText());
                        textFieldsy[i] = new JTextField(10);
                        textFieldsy[i].setText(textFieldsy[i].getText());
                    }
        
                    SHPBeforeClip shpBeforeClip = new SHPBeforeClip(sides,Wxmin, Wymin, Wxmax, Wymax, textFieldsx, textFieldsy);
                    shpBeforeClip.setVisible(true);
                    
                    
                    // if (textFieldsx != null && textFieldsy != null ) {
                    //     SHPBeforeClip shpBeforeClip = new SHPBeforeClip(Wxmin,Wymin,Wxmax,Wymax,textFieldsx,textFieldsy);
                        
                    //     shpBeforeClip.setVisible(true);
                    // }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SHPFrame.this, "Please enter valid integer values.");
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

        

       textFieldsx = new JTextField[sides];
                textFieldsy = new JTextField[sides];
                 for (int i = 0; i < sides; i++) {
            textFieldsx[i] = new JTextField(10);
            textFieldsx[i].setBounds(400 + i * 80, 250 , 50, 20);
            textFieldsx[i].setBackground(Color.WHITE);

            textFieldsy[i] = new JTextField(10);
            textFieldsy[i].setBounds(400 + i * 80 , 300 , 50, 20);
            textFieldsy[i].setBackground(Color.WHITE);
            newFrame.add(textFieldsx[i]);
            newFrame.add(textFieldsy[i]);
        }
        newFrame.setVisible(true);
    }

    private int promptUserForNumberOfFields() {
        String input = JOptionPane.showInputDialog("Enter the number Sides of Polygon");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Using 0 text fields.");
            return 0;
        }
    }

    
}

    


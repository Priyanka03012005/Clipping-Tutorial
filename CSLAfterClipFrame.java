package Mini;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CSLAfterClipFrame extends JFrame{
    int rcode_begin[] = {0, 0, 0, 0};
    int rcode_end[] = {0, 0, 0, 0};
    int region_code[] = new int[4];
    int flag = 0;
    CSLAfterClipFrame(int x1,int y1,int x2, int y2,  int Wxmin,int Wymin, int Wxmax,int Wymax){
        JFrame newFrame = new JFrame("Clipping Tutorial -> Line -> Cohen Sutherland Line Clipping Algorithm -> Output -> After Clipping");
        newFrame.setSize(1200, 800);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setVisible(true);

        JButton HomeButton = new JButton("Home");
        HomeButton.setBounds(600, 500, 150, 30); // Set the button's position and size
        newFrame.add(HomeButton);

        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               HomeFrame hf = new HomeFrame();
               newFrame.dispose();
            }
        });
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                clear(g, Color.WHITE);

               int W_xmin = Wxmin;
               int W_ymin = Wymin;
               int W_xmax = Wxmax;
               int W_ymax = Wymax;
               int x = x1;
               int y = y1;
               int x1 = x2;
               int y1 = y2;

                g.setColor(Color.BLACK);
                g.drawRect(W_xmin, W_ymin, W_xmax - W_xmin, W_ymax - W_ymin);
                //g.drawLine(x, y, x1, y1);

                if (y > W_ymax) {
                    rcode_begin[0] = 1; // Top
                    int flag = 1;
                }
                if (y < W_ymin) {
                    rcode_begin[1] = 1; // Bottom
                   int flag = 1;
                }
                if (x > W_xmax) {
                    rcode_begin[2] = 1; // Right
                   int flag = 1;
                }
                if (x < W_xmin) {
                    rcode_begin[3] = 1; // Left
                   int flag = 1;
                }

                // End point of Line
                if (y1 > W_ymax) {
                    rcode_end[0] = 1; // Top
                   int flag = 1;
                }
                if (y1 < W_ymin) {
                    rcode_end[1] = 1; // Bottom
                    int flag = 1;
                }
                if (x1 > W_xmax) {
                    rcode_end[2] = 1; // Right
                    int flag = 1;
                }
                if (x1 < W_xmin) {
                    rcode_end[3] = 1; // Left
                    int flag = 1;
                }

                if (flag == 0) {
                    System.out.println("No need for clipping as it is already in the window");
                }
               int flag = 1;

                for (int i = 0; i < 4; i++) {
                    region_code[i] = rcode_begin[i] & rcode_end[i];
                    if (region_code[i] == 1)
                        flag = 0;
                }

                if (flag == 0) {
                    System.out.println("Line is completely outside the window");
                } else {
                    float slope = (float) (y1 - y) / (x1 - x);
                    if (rcode_begin[2] == 0 && rcode_begin[3] == 1) { // Left
                        y = (int) (y + (W_xmin - x) * slope);
                        x = W_xmin;
                    }
                    if (rcode_begin[2] == 1 && rcode_begin[3] == 0) { // Right
                        y = (int) (y + (W_xmax - x) * slope);
                        x = W_xmax;
                    }
                    if (rcode_begin[0] == 1 && rcode_begin[1] == 0) { // Top
                        x = (int) (x + (W_ymax - y) / slope);
                        y = W_ymax;
                    }
                    if (rcode_begin[0] == 0 && rcode_begin[1] == 1) { // Bottom
                        x = (int) (x + (W_ymin - y) / slope);
                        y = W_ymin;
                    }

                    // End points
                    if (rcode_end[2] == 0 && rcode_end[3] == 1) { // Left
                        y1 = (int) (y1 + (W_xmin - x1) * slope);
                        x1 = W_xmin;
                    }
                    if (rcode_end[2] == 1 && rcode_end[3] == 0) { // Right
                        y1 = (int) (y1 + (W_xmax - x1) * slope);
                        x1 = W_xmax;
                    }
                    if (rcode_end[0] == 1 && rcode_end[1] == 0) { // Top
                        x1 = (int) (x1 + (W_ymax - y1) / slope);
                        y1 = W_ymax;
                    }
                    if (rcode_end[0] == 0 && rcode_end[1] == 1) { // Bottom
                        x1 = (int) (x1 + (W_ymin - y1) / slope);
                        y1 = W_ymin;
                    }

                    g.setColor(Color.RED);
                    g.drawLine(x, y, x1, y1);
                }
            }

            public void clear(Graphics g, Color color) {
                g.setColor(color);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        newFrame.add(panel);
    }
    
}

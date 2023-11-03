package Mini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LBLAfterClipFrame extends JFrame{
    private int x0, y0, x3, y3;
    LBLAfterClipFrame(int x1,int y1,int x2, int y2,  int Wxmin,int Wymin, int Wxmax,int Wymax){
        JFrame newFrame = new JFrame("Clipping Tutorial -> Line -> Liang-Barsky Line Clipping Algorithm -> Output -> Before Clipping");
        newFrame.setSize(1200, 800);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setVisible(true);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                clear(g, Color.WHITE);

                g.setColor(Color.BLACK);
                g.drawRect(Wxmin, Wymin, Wxmax - Wxmin, Wymax - Wymin);

        int dx = x2 - x1;
        int dy = y2 - y1;

        double p1 = -dx;
        double p2 = dx;
        double p3 = -dy;
        double p4 = dy;

        double q1 = x1 - Wxmin;
        double q2 = Wxmax - x1;
        double q3 = y1 - Wymin;
        double q4 = Wymax - y1;

        double u1 = q1 / p1;
        double u2 = q2 / p2;
        double u3 = q3 / p3;
        double u4 = q4 / p4;

        double uMin = Math.max(0, Math.max(Math.min(u1, u2), Math.min(u3, u4)));
        double uMax = Math.min(1, Math.min(Math.max(u1, u2), Math.max(u3, u4)));
      
        if (uMin <= uMax) {
             x0 = (int) (x1 + uMin * dx);
             y0 = (int) (y1 + uMin * dy);
             x3 = (int) (x1 + uMax * dx);
             y3 = (int) (y1 + uMax * dy);
        }
        g.setColor(Color.RED);
        g.drawLine(x0, y0, x3, y3);
      }
        public void clear(Graphics g, Color color) {
            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };

        newFrame.add(panel);
    }
    
}
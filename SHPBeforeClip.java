 package Mini;


import java.awt.*;
import java.awt.geom.Line2D;
import java.util.*;

import javax.swing.*;


public class SHPBeforeClip extends JFrame {
    // ... Existing code ...

    private double[] subjectX, subjectY, clipperX, clipperY, resultX, resultY;

    public SHPBeforeClip(int sides, int Wxmin, int Wymin, int Wxmax, int Wymax, JTextField[] valuesx, JTextField[] valuesy) {
        setLayout(new BorderLayout());

 

        subjectX = new double[sides];
        subjectY = new double[sides];
        // Initialize subjectX and subjectY arrays as you did before

 

        resultX = new double[sides];
        resultY = new double[sides];

 

        clipPolygon();

 

        PolygonPanel panel = new PolygonPanel(resultX, resultY);
        add(panel, BorderLayout.CENTER);
        setTitle("SutherlandHodgman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

 

    // ... Existing code ...

    private void clipPolygon() {
        int len = clipperX.length;
        for (int i = 0; i < len; i++) {
            int len2 = resultX.length;
            double[] inputX = resultX;
            double[] inputY = resultY;
            resultX = new double[len2];
            resultY = new double[len2];
            double A[] = {clipperX[(i + len - 1) % len], clipperY[(i + len - 1) % len]};
            double B[] = {clipperX[i], clipperY[i]};
            for (int j = 0; j < len2; j++) {
                double P[] = {inputX[(j + len2 - 1) % len2], inputY[(j + len2 - 1) % len2]};
                double Q[] = {inputX[j], inputY[j]};
                if (isInside(A, B, Q)) {
                    if (!isInside(A, B, P)) {
                        double intersectionPoint[] = intersection(A, B, P, Q);
                        resultX[j] = intersectionPoint[0];
                        resultY[j] = intersectionPoint[1];
                    } else {
                        resultX[j] = Q[0];
                        resultY[j] = Q[1];
                    }
                } else if (isInside(A, B, P)) {
                    double intersectionPoint[] = intersection(A, B, P, Q);
                    resultX[j] = intersectionPoint[0];
                    resultY[j] = intersectionPoint[1];
                }
            }
        }
    }

    private boolean isInside(double A[], double B[], double C[]) {
        return (A[0] - C[0]) * (B[1] - C[1]) > (A[1] - C[1]) * (B[0] - C[0]);
    }

    private double[] intersection(double A[], double B[], double P[], double Q[]) {
        double A1 = B[1] - A[1];
        double B1 = A[0] - B[0];
        double C1 = A1 * A[0] + B1 * A[1];
        double A2 = Q[1] - P[1];
        double B2 = P[0] - Q[0];
        double C2 = A2 * P[0] + B2 * P[1];
        double det = A1 * B2 - A2 * B1;
        double x = (B2 * C1 - B1 * C2) / det;
        double y = (A1 * C2 - A2 * C1) / det;
        return new double[]{x, y};
    }


    class PolygonPanel extends JPanel {
        double[] xPoints, yPoints;

 

        public PolygonPanel(double[] xPoints, double[] yPoints) {
            this.xPoints = xPoints;
            this.yPoints = yPoints;
        }

 

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.translate(80, 60);
            g2.setStroke(new BasicStroke(3));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            drawPolygon(g2, xPoints, yPoints, Color.green);
        }

 

        private void drawPolygon(Graphics2D g2, double[] xPoints, double[] yPoints, Color color) {
            g2.setColor(color);
            int len = xPoints.length;
            Line2D line = new Line2D.Double();
            for (int i = 0; i < len; i++) {
                double x1 = xPoints[i];
                double y1 = yPoints[i];
                double x2 = xPoints[(i + 1) % len];
                double y2 = yPoints[(i + 1) % len];
                line.setLine(x1, y1, x2, y2);
                g2.draw(line);
            }
        }
    }

 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTextField[] valuesx = {
                new JTextField("50"), new JTextField("200"), new JTextField("350"),
                // Add more values as needed
            };

 

            JTextField[] valuesy = {
                new JTextField("150"), new JTextField("50"), new JTextField("150"),
                // Add more values as needed
            };

 

            SHPBeforeClip frame = new SHPBeforeClip(valuesx.length, 100, 100, 300, 300, valuesx, valuesy);
            frame.setVisible(true);
        });
    }
}

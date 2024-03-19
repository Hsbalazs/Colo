import java.awt.*;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Drawing code goes here
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                g.drawRect(1 + i * 40, 1 + j * 40,40,40);
            }
        }
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.drawRect(1 + i * 120,1 + j * 120,120,120);
            }
        }
    }

}
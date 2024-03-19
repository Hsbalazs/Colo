import javax.swing.*;
import java.awt.*;

public class Java2DGraphics {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("name");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(new DrawingPanel());
        jframe.setPreferredSize(new Dimension(377,399));
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}

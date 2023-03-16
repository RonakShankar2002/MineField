package mf;
import tools.Subscriber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MineField extends JPanel implements Subscriber {

    public MineField() {
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        setBorder(blackLine);
        setBackground(Color.LIGHT_GRAY);
    }

    public void update() {
        repaint();
    }


    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        gc.setColor(oldColor);
    }
}

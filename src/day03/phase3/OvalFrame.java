package day03.phase3;

import java.awt.*;

public class OvalFrame extends CommonView {

    private int count;
    private Observable observable;

    public OvalFrame(int posX, int posY) {
        super("OvalFrame", posX, posY);
    }

    @Override
    public void update(java.util.Observable o, Object o1) {
        count = (int)o1;
        repaint();
    }

    public void paint(Graphics display) {
        // clear display first
        Dimension dims = getSize();
        display.clearRect(0, 0, dims.width, dims.height);

        int x = 50;
        int y = 30;

        // Magnify value by 9 to get a bigger visual effect
        int height = count * 9;
        int width = count * 9;

        display.setColor(Color.orange);

        display.fillOval(x, y, Math.abs(width), Math.abs(height));
    }

}

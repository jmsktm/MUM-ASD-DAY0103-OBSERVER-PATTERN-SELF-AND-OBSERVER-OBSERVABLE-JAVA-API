package day03.phase3;

import java.awt.*;
import java.util.Observable;

public class RectFrame extends CommonView {

    private int count;

    public RectFrame(int posX, int posY) {
        super("RectWindow", posX, posY);
    }

    @Override
    public void update(Observable o, Object o1) {
        count = (int) o1;
        repaint();
    }

    public void paint(Graphics display) {
        // clear display first
        Dimension sizes = getSize();
        display.clearRect(0, 0, sizes.width, sizes.height);

        int x = 50;
        int y = 30;

        // Magnify value by 9 to get a bigger visual effect
        int height = count * 9;
        int width = count * 9;

        display.setColor(Color.orange);

        display.fillRect(x, y, Math.abs(width), Math.abs(height));
    }

}

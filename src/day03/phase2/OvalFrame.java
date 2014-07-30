package day03.phase2;

import java.awt.*;
import javax.swing.JFrame;

public class OvalFrame extends JFrame implements java.util.Observer {

    private int count;
    private Observable observable;

    public OvalFrame() {
        getContentPane().setLayout(null);
        setSize(300, 200);
        setTitle("OvalFrame");
        setCount(0);

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
    }

    @Override
    public void update(java.util.Observable o, Object o1) {
        count = (int)o1;
        repaint();
    }

    class SymWindow extends java.awt.event.WindowAdapter {

        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == OvalFrame.this) {
                OvalFrame_WindowClosing(event);
            }
        }
    }

    void OvalFrame_WindowClosing(java.awt.event.WindowEvent event) {
        dispose();		 // dispose of the Frame.
    }

    public void setCount(int cnt) {
        count = cnt;
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

        display.setColor(Color.BLUE);

        display.fillOval(x, y, Math.abs(width), Math.abs(height));
    }

}

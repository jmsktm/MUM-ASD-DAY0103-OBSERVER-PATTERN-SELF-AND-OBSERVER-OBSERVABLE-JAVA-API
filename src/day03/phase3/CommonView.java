package day03.phase3;

import javax.swing.JFrame;

public abstract class CommonView extends JFrame implements java.util.Observer {

    private int count;
    private Observable observable;

    public CommonView(String viewName, int posX, int posY) {
        getContentPane().setLayout(null);
        setSize(300, 200);
        setTitle(viewName);
        count=0;

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        
        this.setBounds(posX, posY, 300, 200);
        this.setVisible(true);
    }

    class SymWindow extends java.awt.event.WindowAdapter {

        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == CommonView.this) {
                OvalFrame_WindowClosing(event);
            }
        }
    }

    void OvalFrame_WindowClosing(java.awt.event.WindowEvent event) {
        dispose();		 // dispose of the Frame.
    }

}

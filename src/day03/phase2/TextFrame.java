package day03.phase2;

import java.awt.*;
import java.util.Observable;
import javax.swing.JFrame;

public class TextFrame extends JFrame implements java.util.Observer {
    
    private java.util.Observable observable;

    public TextFrame() {
        //{{INIT_CONTROLS
        getContentPane().setLayout(null);
        setSize(227, 196);
        setVisible(false);
        getContentPane().add(JLabelCount);
        JLabelCount.setFont(new Font("Dialog", Font.BOLD, 36));
        JLabelCount.setBounds(48, 48, 170, 86);
        setTitle("TextFrame");
        setCount(0);
		//}}

        //{{REGISTER_LISTENERS
        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
		//}}

		//{{INIT_MENUS
        //}}
    }

    public java.util.Observable getObservable() {
        return observable;
    }

    @Override
    public void update(Observable o, Object o1) {
//        int count = ((Counter)this.observable).getCount();
        int count = (int)o1;
        setCount(count);
    }

    class SymWindow extends java.awt.event.WindowAdapter {

        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == TextFrame.this) {
                TextFrame_WindowClosing(event);
            }
        }
    }

    void TextFrame_WindowClosing(java.awt.event.WindowEvent event) {
        dispose();		 // dispose of the Frame.
    }
    //{{DECLARE_CONTROLS
    javax.swing.JLabel JLabelCount = new javax.swing.JLabel();
	//}}

	//{{DECLARE_MENUS
    //}}
    public void setCount(int count) {
        JLabelCount.setText(String.valueOf(count));
    }
}

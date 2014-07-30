package day03.phase3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Lab0 extends JFrame {

    private Counter counter;

    JButton JButtonIncrease = new JButton();
    JButton JButtonDecrease = new JButton();

    public Lab0() {
        setupMainFrame();
        counter = new Counter();

        TextFrame textf = new TextFrame(250, 0);
        counter.addObserver(textf);

        RectFrame rectf = new RectFrame(250, 200);
        counter.addObserver(rectf);

        OvalFrame ovalf = new OvalFrame(250, 400);
        counter.addObserver(ovalf);

        SymAction aSymAction = new SymAction();

        JButtonIncrease.addActionListener(aSymAction);
        JButtonDecrease.addActionListener(aSymAction);
    }

    static public void main(String args[]) {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            (new Lab0()).setVisible(true);
        } catch (Throwable t) {
            System.exit(1);
        }
    }

    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {

        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == Lab0.this) {
                JFrameCounter_windowClosing(event);
            }
        }
    }

    void JFrameCounter_windowClosing(java.awt.event.WindowEvent event) {
        JFrameCounter_windowClosing_Interaction1(event);
    }

    void JFrameCounter_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if (object == JButtonIncrease) {
                counter.increment();
            } else if (object == JButtonDecrease) {
                counter.decrement();
            }
            counter.notifyObservers();
        }
    }

    private void setupMainFrame() {
        setTitle("Counting Application: Observer.");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(256, 148);
        setVisible(false);
        JButtonIncrease.setText("+");
        getContentPane().add(JButtonIncrease);
        JButtonIncrease.setBounds(24, 60, 88, 30);
        JButtonDecrease.setText("-");
        getContentPane().add(JButtonDecrease);
        JButtonDecrease.setBounds(148, 60, 88, 30);

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
    }
}

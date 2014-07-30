package day03.phase3;

import java.awt.Font;
import java.util.Observable;

public class TextFrame extends CommonView {
    
    javax.swing.JLabel JLabelCount = new javax.swing.JLabel();

    public TextFrame(int posX, int posY) {
        super("TextFrame", posX, posY);
        getContentPane().add(JLabelCount);
        JLabelCount.setFont(new Font("Dialog", Font.BOLD, 36));
        JLabelCount.setBounds(48, 48, 170, 86);
        setCount(0);
    }

    @Override
    public void update(Observable o, Object o1) {
        int count = (int)o1;
        setCount(count);
    }
    
    public void setCount(int count) {
        JLabelCount.setText(String.valueOf(count));
    }
}

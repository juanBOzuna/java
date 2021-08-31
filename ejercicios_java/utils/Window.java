package utils;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    public Window(){
        this.setSize(500, 500);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
       this.getContentPane().add(panel)     ;
    }
}

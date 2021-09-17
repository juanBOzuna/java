package steps;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Step1 {

    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static void main(String[] args) {
        Ventana v = new Ventana(width, height);
        v.setVisible(true);
    }
}

class Ventana extends JFrame {
    public Ventana(int width, int height) {
        setSize(width, height);
        setLayout(null);

        JLabel text = new JLabel("textp");
        JPanel panelP = new JPanel();
        add(panelP);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                panelP.setSize(getWidth(), getHeight());
                System.out.println("width: " + getWidth() + " height: " + getHeight());
                int width = getWidth();
                int height = getHeight();

                JPanel panelHeader = new JPanel();
                panelHeader.setBackground(Color.BLUE);
                panelHeader.setBounds(0, 0, getWidth(), (int) (getHeight() / 6));

                text.setBounds((int) (width * 0.05), (int) (height * 0.05), (35 * (text.getText().length())), 100);

                panelP.setSize(getWidth(), getHeight());
                panelP.setBackground(Color.white);
                panelP.setLayout(null);

                int sizeFont = (int) (width * 0.03);
                text.setFont(new Font("britannic bold", 0, sizeFont));
                text.setBounds((int) (width * 0.05), (int) (height * 0.05),
                        (int) (sizeFont * (text.getText().length())), 100);
                panelP.add(text);
                panelP.add(panelHeader);
            }
        });
    }

    JPanel header() {
        JPanel header = new JPanel();

        return header;
    }

}

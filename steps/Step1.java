package steps;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

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
        ColorUIResource colorTrue = new ColorUIResource(221, 75, 57);
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
                panelHeader.setBackground(colorTrue);
                panelHeader.setBounds(0, 0, width, (int) (height*0.07 ));

                // text.setBounds((int) (width * 0.05), (int) (height * 0.05), (35 * (text.getText().length())), 100);

                JPanel panelImage1 = new JPanel();
                 panelImage1.setBounds(0, (int) (height / 2.8), (int)(width*0.05) ,(int)(height*0.05) );
                 panelImage1.setBackground(Color.white);

                 Image img = new ImageIcon(!launching.getIsDoubleForFail() ? launching.getDice1().getRelativePath()
                : "ejercicios_java_parcial_2/ejercicio_gui_6/assets/" + terms.getDoubleForFail() + "MataTodo.png")
                        .getImage();

                panelP.setSize(getWidth(), getHeight());
                panelP.setBackground(Color.white);
                panelP.setLayout(null);
                panelP.add(panelHeader);
            }
        });
    }

    

    JPanel header() {
        JPanel header = new JPanel();

        return header;
    }

}

package step_5;

import javax.swing.*;
import java.lang.*;

import java.awt.*;

public class Ventana2 extends JFrame {

    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana2(int dato) {

        int x = 20, y = 20, widthP = 100, heightP = 25;

        int size_total = y*dato +( heightP*(dato-1) );

        // if (size_total < height) {
        //     if(dato<7 ){
        //     setSize(width / 3, size_total+42);
        //     }else{
        //     setSize(width / 3, size_total);
        //     }

        //     System.out.print(" sii" + " " + size_total);
        // } else {
        //     setSize(width / 3, height);
        //     System.out.print(" noo");
        // }

        System.out.print("Size total: " + size_total);
        System.out.print(" Size pantalla: " + height);

        JPanel panelP = new JPanel();
        panelP.setBackground(Color.white);
        panelP.setSize(width / 3, height / 3);
        panelP.setLayout(null);
        add(panelP);

        JButton boton = new JButton();
        boton.setText("adsd  ");
        boton.setBounds(20, 20, 100, 25);

        JPanel panelbutton = new JPanel();
        panelbutton.setBackground(Color.gray);
        panelbutton.setBounds((width / 3) / 2 - 50, 100 - 12, 100, 25);
        panelbutton.setLayout(new GridLayout(1, 1));

        int y2 = 0;
        for (int i = 0; i < dato; i++) {

            if (i == 0) {
                y2 = y;
            } else {
                y2 = y2 + heightP + 5;

            }
            panelP.add(panel(x, y2, widthP, heightP));
        }

          if (size_total < height) {
            if(dato<7 ){
            setSize(width / 3, y2+heightP+5+45);
            }else{
            setSize(width / 3, y2+heightP+5+45);
            }

            System.out.print(" sii" + " " + size_total);
        } else {
            setSize(width / 3, height);
            System.out.print(" noo");
        }

    }

    JPanel panel(int x, int y, int widths, int heights) {
        JPanel panelbutton = new JPanel();
        panelbutton.setBackground(Color.gray);
        panelbutton.setBounds(x, y, widths, heights);
        panelbutton.setLayout(new GridLayout(1, 1));

        return panelbutton;
    }
}

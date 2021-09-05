
package step_5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ventana1 extends JFrame {
    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana1() {
        setSize(width / 3, height / 3);

        JPanel panelP = new JPanel();
        panelP.setBackground(Color.white);
        panelP.setSize(width / 3, height / 3);
        panelP.setLayout(null);
        add(panelP);

        JButton boton = new JButton();
        boton.setText("adsd");
        boton.setBounds(20, 20, 100, 25);
        JPanel panelbutton = new JPanel();
        panelbutton.setBackground(Color.gray);
        panelbutton.setBounds((width / 3) / 2 - 50, 100 - 12, 100, 25);
        panelbutton.setLayout(new GridLayout(1, 1));
        panelbutton.add(boton);

        panelP.add(panelbutton);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {

                Ventana2 ventana = new Ventana2(596);
                ventana.setVisible(true);

            }
        });

    }
}

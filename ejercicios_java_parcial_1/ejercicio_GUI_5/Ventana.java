package ejercicio_GUI_5;

import javax.swing.*;

import methods.DigitOnlyFormKeyListener;
import java.awt.*;

import java.awt.event.*;

public class Ventana extends JFrame {
    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana() {
        setSize(width / 3, height / 3);

        JPanel panelP = new JPanel();
        panelP.setSize(width / 3, height / 3);
        setLayout(null);
        panelP.setLayout(null);
        panelP.setBackground(Color.white);
        panelP.add(title());
        JTextField form = new JTextField();
        panelP.add(formAnio(form));
        panelP.add(panelTitleForm());
        panelP.add(boton(form));

        add(panelP);
    }

    JPanel title() {
        JPanel panelTitle = new JPanel();
        panelTitle.setSize(width, height);
        panelTitle.setBackground(Color.white);
        panelTitle.setSize(width / 3, height / 18);
        panelTitle.setLayout(new GridLayout(1, 1));
        JLabel title = new JLabel();
        title.setText("Calcular anio bisiesto");
        title.setFont(new Font("britannic bold", 0, (int) (height * 0.04)));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.BOTTOM);
        panelTitle.add(title);
        return panelTitle;
    }

    JPanel panelTitleForm() {
        JLabel text = new JLabel("Digite un anio");
        text.setHorizontalTextPosition(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        JPanel panel = new JPanel();
        panel.setBounds((width / 3) / 2 - width / 12, (int) (height * 0.055) + 20, width / 6, (int) (height * 0.04));
        panel.setLayout(new GridLayout(1, 1));
        panel.add(text);
        System.out.print(height * 0.0525);
        panel.setBackground(Color.white);
        return panel;

    }

    JTextField formAnio(JTextField form) {

        DigitOnlyFormKeyListener keyListener = new DigitOnlyFormKeyListener();
        form.setSize(width / 6, (int) (height / 7.5));
        form.setBounds((width / 3) / 2 - width / 12, (int) (height * 0.095) + 20, width / 6, (int) (height * 0.0525));
        form.addKeyListener(keyListener);
        return form;
    }

    JButton boton(JTextField form) {
        JButton button = new JButton();
        button.setBounds((width / 3) / 2 - width / 12, (int) (height * 0.1475) + 25, width / 6, (int) (height / 19));
        button.setText("Calcular");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                int fecha = Integer.parseInt(form.getText());

                if ((fecha % 4 == 0 && fecha % 100 != 0) || fecha % 400 == 0) {
                    JOptionPane.showMessageDialog(null, "El anio NO es bisiesto");
                } else {
                    JOptionPane.showMessageDialog(null, "El anio SI es bisiesto");
                }
                form.setText("");
            }
        });

        return button;
    }

}

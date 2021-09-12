package ejercicios_java_parcial_2.ejercicio_gui_2.refactor;

import javax.swing.*;

import ejercicios_java_parcial_2.methods.DigitOnlyFormKeyListener;
import ejercicios_java_parcial_2.methods.HintTextListener;

import java.awt.event.*;
import java.awt.*;

public class Ventana1 extends JFrame {
    public Ventana1() {
        setLayout(null);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setBackground(Color.white);
        setSize((int) (width * 0.3), (int) (height / 2.8));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panePrincipal = new JPanel();
        panePrincipal.setSize((int) (width * 0.3), (int) (height / 2.5));
        panePrincipal.setBackground(Color.white);
        panePrincipal.setLayout(null);
        add(panePrincipal);

        JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height);
        panePrincipal.add(titleHeader);

        JTextField form = new JTextField();
        JpanelTextForm texform = new JpanelTextForm(width, height, form);
        panePrincipal.add(texform);

        JpanelButton button = new JpanelButton((int) (width * 0.3), height, form);
        panePrincipal.add(button);

    }
}

/**
 * JpanelHeaderTitle
 */
class JpanelHeaderTitle extends JPanel {
    public JpanelHeaderTitle(int width, int height) {
        this.setBounds(20, 5, (int) (width * 0.3 - 60), (int) (height * 0.10));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2, 1));
        // this.setSize(width, height);

        JLabel text = new JLabel();
        text.setText("Lanzamiento de dos dados");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("britannic bold", 0, 25));
        add(text);
    }
}

/**
 * JpanelTexFormAltura
 */
class JpanelTextForm extends JPanel {
    public JpanelTextForm(int width, int height, JTextField form) {
        this.setBounds(((int) (width * 0.3) - (int) (width * 0.20)) / 2, (int) (height * 0.10) - 15,
                (int) (width * 0.20 - 20), (int) (height * 0.13));
        this.setBackground(Color.white);
        this.setLayout(null);

        JLabel text = new JLabel();
        text.setText("Cuantas veces desea lanzarlos");
        text.setHorizontalAlignment(SwingConstants.CENTER);

        text.setFont(new Font("abadi", 2, 15));
        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 25, (int) (width * 0.20 - 20), 30);
        textPanel.add(text);
        textPanel.setBackground(Color.white);
        add(textPanel);

        form.setText("0");
        form.setSize((int) (width * 0.25 - 20), 20);
        form.setBounds(0, 65, (int) (width * 0.20 - 20), 20);
        form.setHorizontalAlignment(SwingConstants.CENTER);

        DigitOnlyFormKeyListener keyListenersDigitOnly = new DigitOnlyFormKeyListener();
        form.addKeyListener(keyListenersDigitOnly);
        HintTextListener focusAdapterForm2 = new HintTextListener(form, "0");
        form.addFocusListener(focusAdapterForm2);
        // text.setFont(new Font("abadi",2,15) );
        add(form);

    }
}

/**
 * JpanelButton
 */
class JpanelButton extends JPanel {
    public JpanelButton(int height, int width, JTextField fAltura) {
        this.setBounds(0, 180, width, 150);

        this.setBackground(Color.white);
        this.setLayout(null);
        JButton button = new JButton("Calcular");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(140, 0, 100, 50);
        buttonPanel.add(button);
        buttonPanel.setBackground(Color.white);
        add(buttonPanel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                Ventana2 ventana = new Ventana2(Integer.parseInt(fAltura.getText()));
                ventana.setVisible(true);
            }
        });
    }
}

// package ejercicio_1;

// import java.awt.*;
// import javax.swing.*;
// import java.awt.event.*;

// public class Ventana1 extends JFrame {
//     static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//     static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

//     public Ventana1() {
//         setSize(width / 3, height / 3);

//         JPanel panelP = new JPanel();
//         panelP.setBackground(Color.white);
//         panelP.setSize(width / 3, height / 3);
//         panelP.setLayout(null);
//         add(panelP);

//         JButton boton = new JButton();
//         boton.setText("adsd");
//         boton.setBounds(20, 20, 100, 25);
//         JPanel panelbutton = new JPanel();
//         panelbutton.setBackground(Color.gray);
//         panelbutton.setBounds((width / 3) / 2 - 50, 100 - 12, 100, 25);
//         panelbutton.setLayout(new GridLayout(1, 1));
//         panelbutton.add(boton);

//         panelP.add(panelbutton);

//         boton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent evento) {

//                 Ventana2 ventana = new Ventana2(6);
//                 ventana.setVisible(true);

//             }
//         });

//     }
// }

package ejercicio_1;

import javax.swing.*;

import methods.DigitOnlyFormKeyListener;
import methods.HintTextListener;

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

        // JTextField formBase = new JTextField();
        // JpanelTextFormLarge texFormBase = new JpanelTextFormLarge(width, height,
        // formBase);
        // panePrincipal.add(texFormBase);

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
        text.setText("Lanzamiento de dados");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("britannic bold", 0, 31));
        add(text);

        // JLabel subText = new JLabel();
        // subText.setHorizontalAlignment(SwingConstants.CENTER);
        // subText.setVerticalAlignment(SwingConstants.TOP);
        // subText.setText("Resultados en m cm y mm cuadrados");
        // subText.setFont(new Font("abadi", 0, 10));
        // add(subText);
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
        text.setText("Cuantas veces desea lanzar");
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

// /**
// * JpanelTextFormBase
// */
// class JpanelTextFormLarge extends JPanel {
// public JpanelTextFormLarge(int width, int height, JTextField form) {
// this.setBounds((int) (width * 0.135 - 20) + 40, (int) (height * 0.10) - 15,
// (int) (width * 0.135 - 20),
// (int) (height * 0.13));
// this.setBackground(Color.white);
// this.setLayout(null);

// JLabel text = new JLabel();
// text.setText("Largo en metros");
// text.setHorizontalAlignment(SwingConstants.CENTER);
// text.setFont(new Font("abadi", 2, 15));

// JPanel textPanel = new JPanel();
// textPanel.setBounds(0, 25, (int) (width * 0.135 - 20), 30);
// textPanel.add(text);
// textPanel.setBackground(Color.white);
// add(textPanel);

// form.setText("0");
// form.setSize((int) (width * 0.135 - 20), 20);
// form.setBounds(0, 65, (int) (width * 0.135 - 20), 20);
// form.setHorizontalAlignment(SwingConstants.CENTER);

// DigitOnlyFormKeyListener keyListenersDigitOnly = new
// DigitOnlyFormKeyListener();
// form.addKeyListener(keyListenersDigitOnly);
// HintTextListener focusAdapterForm2 = new HintTextListener(form, "0");
// form.addFocusListener(focusAdapterForm2);
// add(form);
// }
// }

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

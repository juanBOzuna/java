package ejercicio_gui_3.una_sola_clase;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdenarNumeros {
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }

}

class Ventana extends JFrame {
    public Ventana() {
        setLayout(null);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setBackground(Color.white);
        // setBounds((int)(width*0.3) ,(int) (height/2.8), (int)(height/2) -
        // ((int)((width*0.3)/2)) , (int)(height/2) );
        setSize((int) (width * 0.25), (int) (height * 0.4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panePrincipal = new JPanel();
        panePrincipal.setSize((int) (width * 0.25), (int) (height * 0.4));
        panePrincipal.setBackground(Color.white);
        panePrincipal.setLayout(null);
        add(panePrincipal);

        JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height);
        panePrincipal.add(titleHeader);

        JTextField form1 = new JTextField();
        JpanelTexFormWidth texform1 = new JpanelTexFormWidth("#1", width, height, 20, form1);
        panePrincipal.add(texform1);

        JTextField form2 = new JTextField();
        JpanelTexFormWidth texform2 = new JpanelTexFormWidth("#2", width, height, 45 + (int) (width * 0.07 - 20),
                form2);
        panePrincipal.add(texform2);

        JTextField form3 = new JTextField();
        JpanelTexFormWidth texform3 = new JpanelTexFormWidth("#3", width, height, 65 + (int) ((width * 0.07 - 20) * 2),
                form3);
        panePrincipal.add(texform3);

        JpanelButton button = new JpanelButton((int) (width * 0.3), height, form1, form2, form3);
        panePrincipal.add(button);

    }

    /**
     * JpanelHeaderTitle
     */
    class JpanelHeaderTitle extends JPanel {
        public JpanelHeaderTitle(int width, int height) {
            this.setBounds(20, 5, (int) (width * 0.25 - 60), (int) (height * 0.10));
            this.setBackground(Color.white);
            this.setLayout(new GridLayout(2, 1));
            // this.setSize(width, height);

            JLabel text = new JLabel();
            text.setText("Ordenar 3 Numeros");
            text.setHorizontalAlignment(SwingConstants.CENTER);
            text.setVerticalAlignment(SwingConstants.BOTTOM);
            text.setFont(new Font("britannic bold", 0, 31));
            add(text);

            JLabel subText = new JLabel();
            subText.setHorizontalAlignment(SwingConstants.CENTER);
            subText.setVerticalAlignment(SwingConstants.TOP);
            subText.setText("Resultados de mayor a menor");
            subText.setFont(new Font("abadi", 0, 10));
            add(subText);
        }
    }

}

class JpanelTexFormWidth extends JPanel {
    public JpanelTexFormWidth(String title, int width, int height, int bx, JTextField form) {

        this.setBounds(bx, (int) (height * 0.10) - 15, (int) (width * 0.07 - 20), (int) (height * 0.13));
        this.setBackground(Color.white);
        this.setLayout(null);

        JLabel text = new JLabel();
        text.setText(title);
        text.setHorizontalAlignment(SwingConstants.CENTER);

        text.setFont(new Font("abadi", 2, 15));
        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 25, (int) (width * 0.07 - 20), 30);
        textPanel.add(text);
        textPanel.setBackground(Color.white);
        add(textPanel);

        form.setText("0");
        form.setBounds(0, 65, (int) (width * 0.07 - 20), 30);
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
    public JpanelButton(int height, int width, JTextField n1, JTextField n2, JTextField n3) {
        this.setBounds(0, 180, width, 150);

        // ColorUIResource colorAttribute = new ColorUIResource(0, 124, 124);
        this.setBackground(Color.white);
        this.setLayout(null);
        JButton button = new JButton("ORDENAR");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(105, 10, 100, 50);
        buttonPanel.add(button);
        buttonPanel.setBackground(Color.white);
        add(buttonPanel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    ArrayList<Double> arrayListInt = new ArrayList<Double>();

                    double number = Double.parseDouble(n1.getText().replace(",", "."));
                    arrayListInt.add(number);
                    number = Double.parseDouble(n2.getText().replace(",", "."));
                    arrayListInt.add(number);
                    number = Double.parseDouble(n3.getText().replace(",", "."));
                    arrayListInt.add(number);

                    String message = "";
                    int index = 0;

                    Comparator<Double> comparador = Collections.reverseOrder();
                    Collections.sort(arrayListInt, comparador);

                    for (Double d : arrayListInt) {
                        index++;
                        message += String.valueOf(d).replace(".0", "");
                        if (index < 3) {
                            message += " , ";
                        }
                    }
                    JOptionPane.showMessageDialog(null, message, "Numeros ordenados", 1);

                } catch (Exception e) {
                }
            }
        });
    }
}

class DigitOnlyFormKeyListener extends KeyAdapter {

    public void keyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '.')
                && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
            evt.consume();
        }
    }
}

class HintTextListener extends FocusAdapter {
    JTextField form = new JTextField();
    String titleGeneral;

    public HintTextListener(JTextField f, String t) {
        form = f;
        titleGeneral = t;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (form.getText().equals(titleGeneral)) {
            form.setText("");
        } else {
            form.setText(form.getText());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (form.getText().equals(titleGeneral) || form.getText().length() == 0) {
            form.setText(titleGeneral);
        } else {
            form.setText(form.getText());
        }
    }
}

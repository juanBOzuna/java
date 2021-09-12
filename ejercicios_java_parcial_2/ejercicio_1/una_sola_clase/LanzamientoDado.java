package ejercicios_java_parcial_2.ejercicio_1.una_sola_clase;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

public class LanzamientoDado {
    public static void main(String[] args) {
        Ventana1 v = new Ventana1();
        v.setVisible(true);
        // System.out.print("Asd");
    }
}

class Ventana1 extends JFrame {
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
        text.setText("Lanzamiento de un dado");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("britannic bold", 0, 31));
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

class Ventana2 extends JFrame {

    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana2(int dato) {

        int x = 20, y = (int) (height * 0.0258), widthP = (int) (height * 0.07), heightP = (int) (height * 0.07);
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0;

        JScrollPane panelScroll = new JScrollPane();
        JPanel panelP = new JPanel();
        int y2 = 0;
        int y3 = 0;
        int valorDado = 0;
        String ruta = "";

        for (int i = 0; i < dato; i++) {
            valorDado = (int) (Math.random() * 6 + 1);
            if (i == 0) {
                y2 = y;
            } else {
                y2 = y2 + heightP + 5;

            }
            ruta = "ejercicios_java_parcial_2/ejercicio_1/assets/cara-" + Integer.toString(valorDado)
                    + "-removebg-preview.png";
            panelP.add(panel(x, y2, widthP, heightP, ruta));
            panelP.add(panel2(x + widthP + 5, y2, 200, heightP, i + 1 + ": " + valorDado, "", true));

            switch (valorDado) {
                case 1:
                    d1++;
                    break;
                case 2:
                    d2++;
                    break;
                case 3:
                    d3++;
                    break;
                case 4:
                    d4++;
                    break;
                case 5:
                    d5++;
                    break;
                default:
                    d6++;
                    break;
            }
        }

        panelP.add(panel((width / 4) + 95, y, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-1-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y, 200, heightP - 10, "" + 1,
                " " + d1 + (d1 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + y + heightP - 5, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-2-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + y + heightP - 5, 200, heightP - 10, "" + 1,
                " " + d2 + (d2 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 2, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-3-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 2, 200, heightP - 10, "" + 1,
                " " + d3 + (d3 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 3, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-4-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 3, 200, heightP - 10, "" + 1,
                " " + d4 + (d4 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 4, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-5-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 4, 200, heightP - 10, "" + 1,
                " " + d5 + (d5 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 5, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-6-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 5, 200, heightP - 10, "" + 1,
                " " + d6 + (d6 > 1 ? " veces" : " vez"), false));

        if (y * dato + (heightP * (dato - 1)) < height) {
            if (dato > 7) {
                setSize(width / 2, y2 + heightP + 5 + 95);
                panelScroll.setBounds(10, 10, width / 2, y2 + heightP + 5 + 60);

                DividerPrincipal divider = new DividerPrincipal(width / 2, y, y, y2 + heightP - 10, 1);
                panelP.add(divider);
            } else {
                setSize(width / 2, ((y + heightP + 5) * 6) + 90);
                panelScroll.setBounds(10, 10, width / 2, ((y + heightP + 5) * 6) + 60);

                DividerPrincipal divider = new DividerPrincipal(width / 2, 0, y, ((y + heightP) * dato) - 10, 1);
                panelP.add(divider);
                System.out.print("si.");
            }

        } else {
            setSize(width / 2, (int) (height * 0.9));
            panelScroll.setBounds(10, 10, width / 2, (int) (height * 0.9));
        }

        panelScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelP.setBackground(Color.white);
        panelP.setLayout(null);
        panelP.setPreferredSize(new DimensionUIResource(width / 2, y2 + heightP + 5 + 45));
        panelScroll.setViewportView(panelP);
        add(panelScroll);

    }

    JPanel panel(int x, int y, int widths, int heights, String ruta) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(x, y, widths, heights);
        panel.setLayout(new GridLayout(1, 1));

        Image img = new ImageIcon(ruta).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(widths, heights, Image.SCALE_SMOOTH));
        JLabel picLabel = new JLabel(img2);

        panel.add(picLabel);

        return panel;
    }

    JPanel panel2(int x, int y, int widths, int heights, String lanzamiento, String txt, boolean lanz) {

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(x, y, widths, heights);
        panel.setLayout(null);
        panel.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel();
        if (lanz) {
            text.setText("Lanzamiento #" + lanzamiento);
        } else {
            text.setText(txt);
        }

        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 20));

        panel.add(text);

        return panel;
    }
}

/**
 * DividerPrincipal
 */
class DividerPrincipal extends JPanel {
    public DividerPrincipal(int width, int height, int boundY, int heightSize, int widthSize) {
        this.setBounds((int) (width / 2) - (widthSize / 2) + 80, boundY, widthSize, heightSize);
        this.setBackground(Color.gray);
        this.setLayout(null);
    }
}


class DigitOnlyFormKeyListener extends KeyAdapter{

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

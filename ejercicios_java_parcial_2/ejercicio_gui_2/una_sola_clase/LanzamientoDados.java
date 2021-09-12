package ejercicios_java_parcial_2.ejercicio_gui_2.una_sola_clase;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.plaf.DimensionUIResource;

public class LanzamientoDados {
    public static void main(String[] args) {
        Ventana1 v = new Ventana1();
        v.setVisible(true);
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

class Ventana2 extends JFrame {
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana2(int dato) {
        setSize((int) (width / 2), 500);
        JPanel panelP = new JPanel();
        JScrollPane panelScroll = new JScrollPane();
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0;

        panelP.setLayout(null);
        panelP.setBackground(Color.white);
        int random1 = 0, random2 = 0;

        for (int i = 0; i < dato; i++) {
            random1 = (int) (Math.random() * 6 + 1);
            random2 = (int) (Math.random() * 6 + 1);
            switch (random1) {
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
            switch (random2) {
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
            if (i == 0) {
                Launching launching = new Launching(20, 10, (int) (width / 4.5) - 20, (int) (height * 0.14), i, random1,
                        random2);
                panelP.add(launching);
            } else {
                Launching launching = new Launching(20, (10 + (int) (height * 0.14)) * i, (int) (width / 4.5) - 20,
                        (int) (height * 0.14), i, random1, random2);
                panelP.add(launching);
            }

        }
        DividerPrincipal divider = new DividerPrincipal(width / 2, 10, (10 + (int) (height * 0.14)) * dato - 1, 1);
        panelP.add(divider);

        if ((30 + (int) (height * 0.14)) * dato - 1 < height) {
            if (dato > 5) {
                setSize(width / 2, (10 + (int) (height * 0.14)) * dato - 1);
                panelScroll.setBounds(10, 10, width / 2, (5 + (int) (height * 0.14)) * dato - 1);
            } else {
                setSize(width / 2, (int) (height * 0.85));
                panelScroll.setBounds(10, 10, width / 2, (int) (height * 0.80));
                System.out.print("si.");
            }

        } else {
            setSize(width / 2, (int) (height * 0.9));
            panelScroll.setBounds(10, 10, width / 2, (int) (height * 0.9));
        }

        panelP.add(panel((width / 4) + 10, 10, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_2/assets/cara-1-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 10, 200, 50, "", " " + d1 + (d1 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 60, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_2/assets/cara-2-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 60, 200, 50, "", " " + d2 + (d2 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 110, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_2/assets/cara-3-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 110, 200, 50, "", " " + d3 + (d3 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 160, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_2/assets/cara-4-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 160, 200, 50, "", " " + d4 + (d4 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 210, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_2/assets/cara-5-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 210, 200, 50, "", " " + d5 + (d5 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 260, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_2/assets/cara-6-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 260, 200, 50, "", " " + d6 + (d6 > 1 ? " veces" : " vez"), false));

        // panelP.add(panel2(0, 0, 200, 0, "" + 1, " = " + dato + (dato > 1 ? " veces" :
        // " vez"), false));

        // panelP.add(panel((width / 4) + 95, y + y + heightP - 5, widthP - 10, heightP
        // - 10,
        // "ejercicios_java_parcial_2/ejercicio_1/assets/cara-2-removebg-preview.png"));
        // panelP.add(panel2(width / 4 + 95 + widthP + 5, y + y + heightP - 5, 200,
        // heightP - 10, "" + 1,
        // " = " + d2 + (d2 > 1 ? " veces" : " vez"), false));

        // panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 2, widthP - 10,
        // heightP - 10,
        // "ejercicios_java_parcial_2/ejercicio_1/assets/cara-3-removebg-preview.png"));
        // panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 2,
        // 200, heightP - 10, "" + 1,
        // " = " + d3 + (d3 > 1 ? " veces" : " vez"), false));

        // panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 3, widthP - 10,
        // heightP - 10,
        // "ejercicios_java_parcial_2/ejercicio_1/assets/cara-4-removebg-preview.png"));
        // panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 3,
        // 200, heightP - 10, "" + 1,
        // " = " + d4 + (d4 > 1 ? " veces" : " vez"), false));

        // panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 4, widthP - 10,
        // heightP - 10,
        // "ejercicios_java_parcial_2/ejercicio_1/assets/cara-5-removebg-preview.png"));
        // panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 4,
        // 200, heightP - 10, "" + 1,
        // " = " + d5 + (d5 > 1 ? " veces" : " vez"), false));

        // panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 5, widthP - 10,
        // heightP - 10,
        // "ejercicios_java_parcial_2/ejercicio_1/assets/cara-6-removebg-preview.png"));
        // panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 5,
        // 200, heightP - 10, "" + 1,
        // " = " + d6 + (d6 > 1 ? " veces" : " vez"), false));

        panelScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelP.setPreferredSize(new DimensionUIResource(width / 2, (10 + (int) (height * 0.14)) * dato - 1));
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
 * Launching
 */
class Launching extends JPanel {

    public Launching(int x, int y, int w, int h, int index, int random1, int random2) {
        setBounds(x, y, w, h);
        setLayout(null);
        setBackground(Color.white);
        JPanel panelText = new JPanel();

        panelText.setBounds(0, 0, w, (int) (h / 2.6));
        panelText.setBackground(Color.white);
        panelText.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel("Lanzamiento #" + index + 1);

        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("book antiqua", 0, 20));
        panelText.add(text);

        int widthDefault = (int) (w / 4.2);
        int heightDefault = h - (int) (h / 2.6);

        JPanel panelImage1 = new JPanel();
        panelImage1.setBounds(0, (int) (h / 2.8), widthDefault, heightDefault);
        panelImage1.setBackground(Color.white);

        Image img = new ImageIcon(
                "ejercicios_java_parcial_2/ejercicio_2/assets/cara-" + random1 + "-removebg-preview.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(widthDefault - 5, heightDefault - 5, Image.SCALE_SMOOTH));
        JLabel picLabel = new JLabel(img2);
        panelImage1.add(picLabel);
        System.out.print((int) (h * 0.605));

        JPanel panelImage2 = new JPanel();
        panelImage2.setBounds(widthDefault + 30, (int) (h / 2.8), widthDefault, heightDefault);
        panelImage2.setBackground(Color.white);

        Image imge2 = new ImageIcon(
                "ejercicios_java_parcial_2/ejercicio_2/assets/cara-" + random2 + "-removebg-preview.png").getImage();
        ImageIcon imge3 = new ImageIcon(
                imge2.getScaledInstance(widthDefault - 5, heightDefault - 5, Image.SCALE_SMOOTH));
        JLabel picLabel2 = new JLabel(imge3);
        panelImage2.add(picLabel2);

        add(panelImage2);
        add(panelImage1);
        add(panelText);
    }

}

/**
 * DividerPrincipal
 */
class DividerPrincipal extends JPanel {
    public DividerPrincipal(int width, int boundY, int heightSize, int widthSize) {
        this.setBounds((int) (width / 2), boundY, widthSize, heightSize);
        this.setBackground(Color.gray);
        this.setLayout(null);
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
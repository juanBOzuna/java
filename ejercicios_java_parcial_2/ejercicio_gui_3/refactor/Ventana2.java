package ejercicios_java_parcial_2.ejercicio_gui_3.refactor;

import java.awt.Color;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.*;

public class Ventana2 extends JFrame {
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana2(int dato) {
        setSize((int) (width / 2), 500);
        JPanel panelP = new JPanel();
        JScrollPane panelScroll = new JScrollPane();
        int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0;

        panelP.setLayout(null);
        panelP.setBackground(Color.white);
        int random1 = 0, random2 = 0, dobles = 0, impar = 0, par = 0, doble1 = 0, lostAttempt = 0, total = 0;

        for (int i = 0; i < dato; i++) {
            random1 = (int) (Math.random() * 6 + 1);
            random2 = (int) (Math.random() * 6 + 1);
            total += random1 + random2;
            switch (random1) {
                case 1:
                    d1++;
                    impar++;
                    break;
                case 2:
                    d2++;
                    par++;
                    break;
                case 3:
                    d3++;
                    impar++;
                    break;
                case 4:
                    d4++;
                    par++;
                    break;
                case 5:
                    d5++;
                    impar++;
                    break;

                default:
                    d6++;
                    par++;
                    break;
            }

            switch (random2) {
                case 1:
                    d1++;
                    impar++;
                    if (random1 == 1) {
                        if (doble1 == 2) {
                            lostAttempt = i + 1;
                        }
                        doble1++;

                    }
                    break;
                case 2:
                    d2++;
                    par++;
                    break;
                case 3:
                    d3++;
                    impar++;
                    break;
                case 4:
                    d4++;
                    par++;
                    break;
                case 5:
                    d5++;
                    impar++;
                    break;

                default:
                    d6++;
                    par++;
                    break;
            }

            if (random1 == random2) {
                dobles++;
            }

            if (i == 0) {
                Launching launching = new Launching(20, 10, (int) (width / 4.5) - 20, (int) (height * 0.14), i, random1,
                        random2, random1 == 1 && random2 == 1);
                panelP.add(launching);
            } else {
                System.out.print("\nIndex bound y actual: " + i);
                Launching launching = new Launching(20, (10 + (int) (height * 0.14)) * i, (int) (width / 4.5) - 20,
                        (int) (height * 0.14), i, random1, random2, random1 == 1 && random2 == 1);
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
            }

        } else {
            setSize(width / 2, (int) (height * 0.9));
            panelScroll.setBounds(10, 10, width / 2, (int) (height * 0.9));
        }

        panelP.add(panel((width / 4) + 10, 10, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_gui_3/assets/cara-1-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 10, 200, 50, "", " " + d1 + (d1 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 60, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_gui_3/assets/cara-2-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 60, 200, 50, "", " " + d2 + (d2 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 110, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_gui_3/assets/cara-3-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 110, 200, 50, "", " " + d3 + (d3 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 160, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_gui_3/assets/cara-4-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 160, 200, 50, "", " " + d4 + (d4 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 210, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_gui_3/assets/cara-5-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 210, 200, 50, "", " " + d5 + (d5 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 10, 260, 50, 50,
                "ejercicios_java_parcial_2/ejercicio_gui_3/assets/cara-6-removebg-preview.png"));
        panelP.add(panel2((width / 4) + 10 + 50, 260, 200, 50, "", " " + d6 + (d6 > 1 ? " veces" : " vez"), false));

        JButton boton = new JButton("Mas detalles");
        boton.setBounds((width / 4) + 10, (int) (width * 0.25), (int) (width * 0.088), 30);

        // System.out.print(width * 0.088);

        JLabel status = new JLabel(doble1 >= 3 ? "Perdio La Partida" : "Gano La Partida ");
        ColorUIResource colorTrue = new ColorUIResource(7, 147, 0);
        ColorUIResource colorFalse = new ColorUIResource(211, 11, 6);
        System.out.print(doble1);
        status.setForeground(doble1 >= 3 ? colorFalse : colorTrue);
        status.setBounds((width / 4) + 10, (int) (width * 0.27) + 20, (int) (width * 0.088), 30);

        final String ms;
        if (doble1 >= 3) {
            ms = "RESULTADOS: \nnumero de dobles obtenidos: " + dobles + "\nnumeros pares: " + par
                    + " \nnumeros impares: " + impar + "\nsuma total: " + total + "\nperdio la partida en el intento #"
                    + lostAttempt;
        } else {
            ms = "RESULTADOS: \nnumero de dobles obtenidos: " + dobles + "\nnumeros pares: " + par
                    + " \nnumeros impares: " + impar + "\nsuma total: " + total;
        }

        boton.addActionListener(new ActionListener() {
            String message = ms;

            @Override
            public void actionPerformed(ActionEvent evento) {
                JOptionPane.showMessageDialog(null, message);
            }

        });

        panelP.add(boton);
        panelP.add(status);

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

    public Launching(int x, int y, int w, int h, int index, int random1, int random2, Boolean status) {
        setBounds(x, y, w, h);
        setLayout(null);
        setBackground(Color.white);
        JPanel panelText = new JPanel();

        panelText.setBounds(0, 0, w, (int) (h / 2.6));
        panelText.setBackground(Color.white);
        panelText.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel("Lanzamiento #" + (index + 1) + " =" + (random1 + random2));

        ColorUIResource colorFalse = new ColorUIResource(211, 11, 6);

        if (status) {
            text.setForeground(colorFalse);
        }

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
                !status ? "ejercicios_java_parcial_2/ejercicio_gui_3/assets/cara-" + random1 + "-removebg-preview.png"
                        : "ejercicios_java_parcial_2/ejercicio_gui_3/assets/1MataTodo.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(widthDefault - 5, heightDefault - 5, Image.SCALE_SMOOTH));
        JLabel picLabel = new JLabel(img2);
        panelImage1.add(picLabel);
        // System.out.print((int) (h * 0.605));

        JPanel panelImage2 = new JPanel();
        panelImage2.setBounds(widthDefault + 30, (int) (h / 2.8), widthDefault, heightDefault);
        panelImage2.setBackground(Color.white);

        Image imge2 = new ImageIcon(
                !status ? "ejercicios_java_parcial_2/ejercicio_gui_3/assets/cara-" + random2 + "-removebg-preview.png"
                        : "ejercicios_java_parcial_2/ejercicio_gui_3/assets/1MataTodo.png").getImage();
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

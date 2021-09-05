package ejercicio_1;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

public class Ventana2 extends JFrame {

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
            panelP.add(panel2(x + widthP + 5, y2, 200, heightP, i+1 + ": " + valorDado, "", true));

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
                " = " + d1 + (d1 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + y + heightP - 5, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-2-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + y + heightP - 5, 200, heightP - 10, "" + 1,
                " = " + d2 + (d2 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 2, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-3-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 2, 200, heightP - 10, "" + 1,
                " = " + d3 + (d3 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 3, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-4-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 3, 200, heightP - 10, "" + 1,
                " = " + d4 + (d4 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 4, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-5-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 4, 200, heightP - 10, "" + 1,
                " = " + d5 + (d5 > 1 ? " veces" : " vez"), false));

        panelP.add(panel((width / 4) + 95, y + ((y + heightP - 5)) * 5, widthP - 10, heightP - 10,
                "ejercicios_java_parcial_2/ejercicio_1/assets/cara-6-removebg-preview.png"));
        panelP.add(panel2(width / 4 + 95 + widthP + 5, y + ((y + heightP - 5)) * 5, 200, heightP - 10, "" + 1,
                " = " + d6 + (d6 > 1 ? " veces" : " vez"), false));

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

    JPanel panel3(int x, int y, int widths, int heights, String ruta) {
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
}

/**
 * DividerPrincipal
 */
class DividerPrincipal extends JPanel {
    public DividerPrincipal(int width, int height, int boundY, int heightSize, int widthSize) {
        this.setBounds((int) (width / 2) - (widthSize / 2) +80, boundY, widthSize, heightSize);
        this.setBackground(Color.gray);
        this.setLayout(null);
    }
}

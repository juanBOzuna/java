package ejercicios_java_parcial_2. ejercicio_5;

import java.awt.Color;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.*;

public class Ventana2 extends JFrame {
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana2(Player player) {
        setSize((int) (width / 2), 500);
        setTitle("Jugador #" + player.getId());

        JPanel panelP = new JPanel();
        JScrollPane panelScroll = new JScrollPane();

        panelP.setLayout(null);
        panelP.setBackground(Color.white);

        int index = 0;
        for (Launching Launching : player.getLaunchings()) {
            index++;
            if (Launching.getId() == 0) {
                JpanelLaunching launching = new JpanelLaunching(20, 10, (int) (width / 4.5) - 20, (int) (height * 0.14),
                        Launching);
                panelP.add(launching);
            } else {
                JpanelLaunching launching = new JpanelLaunching(20, (10 + (int) (height * 0.14)) * Launching.getId(),
                        (int) (width / 4.5) - 20, (int) (height * 0.14), Launching);
                panelP.add(launching);
            }
        }

        DividerPrincipal divider = new DividerPrincipal(width / 2, 10,
                (10 + (int) (height * 0.14)) * player.getLaunchings().size() - 1, 1);
        panelP.add(divider);

        if ((30 + (int) (height * 0.14)) * player.getLaunchings().size() - 1 < height) {
            if (player.getLaunchings().size() > 5) {
                setSize(width / 2, (10 + (int) (height * 0.14)) * player.getLaunchings().size() - 1);
                panelScroll.setBounds(10, 10, width / 2,
                        (5 + (int) (height * 0.14)) * player.getLaunchings().size() - 1);
            } else {
                setSize(width / 2, (int) (height * 0.85));
                panelScroll.setBounds(10, 10, width / 2, (int) (height * 0.80));
            }

        } else {
            setSize(width / 2, (int) (height * 0.9));
            panelScroll.setBounds(10, 10, width / 2, (int) (height * 0.9));
        }

        int boundYDefault = 10;
        for (int i = 0; i < 6; i++) {
            if (i != 0)
                boundYDefault += 50;
            int value = player.getTotalNumbersForPlayer().getListNumbers().get(i + 1);
            panelP.add(panel((width / 4) + 10, boundYDefault, 50, 50,
                    "ejercicios_java_parcial_2/ejercicio_3/assets/cara-" + (i + 1) + "-removebg-preview.png"));

            panelP.add(panel2((width / 4) + 10 + 50, boundYDefault, 200, 50, "",
                    " " + value + (value > 1 ? " veces" : " vez"), false));
        }

        JButton boton = new JButton("Mas detalles");
        boton.setBounds((width / 4) + 10, (int) (width * 0.25), (int) (width * 0.088), 30);

        JLabel status = new JLabel(player.isLoser() ? "Perdio La Partida" : "Gano La Partida ");
        ColorUIResource colorTrue = new ColorUIResource(7, 147, 0);
        ColorUIResource colorFalse = new ColorUIResource(211, 11, 6);
        status.setForeground(player.isLoser() ? colorFalse : colorTrue);
        status.setBounds((width / 4) + 10, (int) (width * 0.27) + 20, (int) (width * 0.088), 30);

        final String ms;
        NumbersForPlayer numbers = player.getTotalNumbersForPlayer();
        // System.out.println("total de numeros: " + numbers.getTotalNumbers());
        if (!player.isLoser()) {
            ms = "RESULTADOS: \nTotal de dobles obtenidos: " + player.getRepeatedEqualDouble()
                    + "\nTotal de numeros pares: " + numbers.getTotalEvenNumber() + "\nTotal de numeros impares: "
                    + numbers.getTotalOddNumbers() + "\nEl numero que mas salió: " + numbers.getNumberHigher()
                    + "\nEl numero que menos salió: " + numbers.getSmallestNumber() + "\nEl promedio de salidas: "
                    + numbers.getAverage() + "\nparejas de numeros repetidas: " + player.getRepeatedLaunching();
        } else {
            ms = "RESULTADOS: \nTotal de dobles obtenidos: " + player.getRepeatedEqualDouble()
                    + "\nTotal de numeros pares: " + numbers.getTotalEvenNumber() + "\nTotal de numeros impares: "
                    + numbers.getTotalOddNumbers() + "\nEl numero que mas salió: " + numbers.getSmallestNumber()
                    + "\nEl numero que menos salió: " + numbers.getNumberHigher() + "\nEl promedio de salidas: "
                    + numbers.getAverage() + "\nparejas de numeros repetidas: " + player.getRepeatedLaunching()
                    + "\nparejas de numeros repetidas: " + player.getRepeatedLaunching()
                    + "\nPerdio la partida en el intento#: " + player.getIndexForFail();
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
        panelP.setPreferredSize(
                new DimensionUIResource(width / 2, (10 + (int) (height * 0.14)) * player.getLaunchings().size() - 1));
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

        text.setText(txt);

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
class JpanelLaunching extends JPanel {

    public JpanelLaunching(int x, int y, int w, int h, Launching launching) {
        setBounds(x, y, w, h);
        setLayout(null);
        setBackground(Color.white);
        JPanel panelText = new JPanel();

        panelText.setBounds(0, 0, w, (int) (h / 2.6));
        panelText.setBackground(Color.white);
        panelText.setLayout(new GridLayout(1, 1));

        // JLabel text = new JLabel("Lanzamiento #" + (index + 1) + " =" + (random1 +
        // random2));
        JLabel text = new JLabel("Lanzamiento #" + (launching.getId() + 1) + " ="
                + (launching.getDice1().getValue() + launching.getDice2().getValue()));

        ColorUIResource colorFalse = new ColorUIResource(211, 11, 6);

        if (launching.isDoubleOne()) {

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

        Image img = new ImageIcon(!launching.isDoubleOne() ? launching.getDice1().getRelativePath()
                : "ejercicios_java_parcial_2/ejercicio_5/assets/1MataTodo.png").getImage();

        ImageIcon img2 = new ImageIcon(img.getScaledInstance(widthDefault - 5, heightDefault - 5, Image.SCALE_SMOOTH));
        JLabel picLabel = new JLabel(img2);
        panelImage1.add(picLabel);

        JPanel panelImage2 = new JPanel();
        panelImage2.setBounds(widthDefault + 30, (int) (h / 2.8), widthDefault, heightDefault);
        panelImage2.setBackground(Color.white);

        Image imge2 = new ImageIcon(!launching.isDoubleOne() ? launching.getDice2().getRelativePath()
                : "ejercicios_java_parcial_2/ejercicio_5/assets/1MataTodo.png").getImage();
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

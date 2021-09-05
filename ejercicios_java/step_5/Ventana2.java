package step_5;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.lang.*;

import java.awt.*;

public class Ventana2 extends JFrame {

    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana2(int dato) {

        int x = 20, y = 20, widthP = 60, heightP = 60;

        int size_total = y * dato + (heightP * (dato - 1));

        JScrollPane panelScroll = new JScrollPane();
        panelScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel panelP = new JPanel();
        panelP.setBackground(Color.white);
        // panelP.setSize(width / 3, (int)(height*0.9) );

        int y2 = 0;
        int valorDado = 0;
        for (int i = 0; i < dato; i++) {
            valorDado = (int) (Math.random() * 6 + 1);
            if (i == 0) {
                y2 = y;
            } else {
                y2 = y2 + heightP + 5;

            }
            panelP.add(panel(x, y2, widthP, heightP, valorDado));
            panelP.add(panel2(x + widthP + 5, y2, 200, heightP,i+1));
        }
        panelP.setLayout(null);
        panelP.setPreferredSize(new DimensionUIResource(width / 3, y2 + heightP + 5 + 45));
        if (size_total < height) {
            setSize(width / 3, y2 + heightP + 5 + 95);
            panelScroll.setBounds(10, 10, width / 3, y2 + heightP + 5 + 60);

        } else {
            setSize(width / 3, (int) (height * 0.9));
            panelScroll.setBounds(10, 10, width / 3, (int) (height * 0.9));
        }

        panelScroll.setViewportView(panelP);

        add(panelScroll);

    }

    JPanel panel(int x, int y, int widths, int heights, int i) {
        JPanel panelbutton = new JPanel();
        panelbutton.setBackground(Color.white);
        panelbutton.setBounds(x, y, widths, heights);
        panelbutton.setLayout(new GridLayout(1, 1));
        String ruta = "ejercicios_java/step_5/assets/cara-" + Integer.toString(i) + "-removebg-preview.png";

        Image img = new ImageIcon(ruta).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(widths, heights, Image.SCALE_SMOOTH));

        JLabel picLabel = new JLabel(img2);

        panelbutton.add(picLabel);

        return panelbutton;
    }

    JPanel panel2(int x, int y, int widths, int heights,int lanzamiento ) {

        JPanel panelbutton = new JPanel();
        panelbutton.setBackground(Color.white);
        panelbutton.setBounds(x, y, widths, heights);
        panelbutton.setLayout(null);
        
        panelbutton.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel();
        text.setText("Lanzamiento #"+lanzamiento);
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 20));

        JPanel panelTitle = new JPanel();

        panelbutton.add(text);

        return panelbutton;
    }
}




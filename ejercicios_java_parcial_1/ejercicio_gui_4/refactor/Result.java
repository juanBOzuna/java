package ejercicios_java_parcial_1. ejercicio_gui_4.refactor;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

public class Result extends JFrame {
    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Result(int width, int height, double hr1, double val1, double hr2, double val2, double hr3, double val3,
            double hr4, double val4, double hr5, double val5, double hr6, double val6, double hr7, double val7,
            double val8, double val9, double aporEps, double aporPension, double cuotaPrestamo, double val10,
            double val11, double val12, String name) {
        // setLayout(null);
        setBackground(Color.white);
        setSize((int) (width * 0.5) + 15, (int) (height * 0.9));
        JPanel panelResult = new JPanel();

        JScrollPane panelScroll = new JScrollPane();
        panelScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelScroll.setBounds(10, 10, (int) (width * 0.5), (int) (height * 0.9));

        // panelResult.setSize((int) (width * 0.5), (int) (height * 0.9));
        panelResult.setPreferredSize(new DimensionUIResource((int) (width * 0.48), (int) (height * 0.85)));
        panelResult.setBackground(Color.white);
        panelResult.setLayout(null);
        addDividersFromResult(panelResult, width, height);

        JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height, "Nomina de empleados");
        panelResult.add(titleHeader);

        JPanelTitleSurchargues titleSurchargues = new JPanelTitleSurchargues(width, height);
        panelResult.add(titleSurchargues);

        JpanelContentSurchargues contentSurchargues = new JpanelContentSurchargues(width, height, hr1, val1, hr2, val2,
                hr3, val3, hr4, val4, hr5, val5, hr6, val6, hr7, val7, val8, val9);
        panelResult.add(contentSurchargues);

        JPanelContentDeductions contentDeductions = new JPanelContentDeductions(width, height, aporEps, aporPension,
                cuotaPrestamo);
        panelResult.add(contentDeductions);

        JPanelFooterResult footer = new JPanelFooterResult(width, height, name, val10, val11, val12);
        panelResult.add(footer);

        JPanelTitleDeductions titleDeductions = new JPanelTitleDeductions(width, height);
        panelResult.add(titleDeductions);

        JPanelImageDductions ImageDeductions = new JPanelImageDductions(width, height);
        panelResult.add(ImageDeductions);

        panelScroll.setViewportView(panelResult);

        add(panelScroll);

    }

    public static void addDividersFromResult(JPanel panel, int width, int height) {
        int primaryBoundY = (int) (height * 0.12);
        int primaryHeightSize = (int) (height * 0.218);
        DividerResult divider1 = new DividerResult(width, height, primaryBoundY, primaryHeightSize, 1);
        panel.add(divider1);

        int secundBoundY = primaryHeightSize + primaryBoundY + 20;
        int secunHeightSize = (int) (height * 0.03);
        DividerResult divider3 = new DividerResult(width, height, secundBoundY, secunHeightSize, 2);
        panel.add(divider3);

        int trheeBoundY = secunHeightSize + secundBoundY + 20;
        int trheeHegihtSize = (int) (height * 0.218);
        DividerResult divider5 = new DividerResult(width, height, trheeBoundY, trheeHegihtSize, 1);
        panel.add(divider5);

    }
}

/**
 * JPanelTitleSurchargues
 */
class JPanelTitleSurchargues extends JPanel {

    public JPanelTitleSurchargues(int width, int height) {
        this.setBounds(20, (int) (height * 0.12), (int) (width * 0.5 / 2) - 100, (int) (height * 0.05));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel();
        text.setText("RECARGOS ");
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 20));
        add(text);
    }
}

/**
 * JPanelTitleDeductions
 */
class JPanelTitleDeductions extends JPanel {

    public JPanelTitleDeductions(int width, int height) {
        this.setBounds((int) ((width * 0.5 / 2) + 50), (int) (height * 0.12), (int) (width * 0.5 / 2) - 50,
                (int) (height * 0.05));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel();
        text.setText("DEDUCCIONES ");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 20));
        add(text);
    }
}

/**
 * JpanelContentSurchargues
 */
class JpanelContentSurchargues extends JPanel {

    public JpanelContentSurchargues(int width, int height, double hr1, double val1, double hr2, double val2, double hr3,
            double val3, double hr4, double val4, double hr5, double val5, double hr6, double val6, double hr7,
            double val7, double val8, double val9) {
        this.setBounds(20, (int) (height * 0.17), (int) (width * 0.5 / 2) + 10, (int) (height * 0.466));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(16, 1));

        JLabel text = new JLabel();
        text.setText("Horas nocturnas: " + String.format("%.02f", hr1));
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 15));
        add(text);

        JLabel text1 = new JLabel();
        text1.setText("recargo nocturno: $" + String.format("%.02f", val1));
        text1.setHorizontalAlignment(SwingConstants.LEFT);
        text1.setVerticalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("bahnschrift", 0, 15));

        add(text1);
        JLabel text2 = new JLabel();
        text2.setText("Horas dominic. fest. dia: " + String.format("%.02f", hr2));
        text2.setHorizontalAlignment(SwingConstants.LEFT);
        text2.setVerticalAlignment(SwingConstants.CENTER);
        text2.setFont(new Font("bahnschrift", 0, 15));
        add(text2);

        JLabel text3 = new JLabel();
        text3.setText("Recargo por hrs dominic. fest. dia: $" + String.format("%.02f", val2));
        text3.setHorizontalAlignment(SwingConstants.LEFT);
        text3.setVerticalAlignment(SwingConstants.CENTER);
        text3.setFont(new Font("bahnschrift", 0, 15));
        add(text3);

        JLabel text4 = new JLabel();
        text4.setText("Horas dominic. fest. noche: " + String.format("%.02f", hr3));
        text4.setHorizontalAlignment(SwingConstants.LEFT);
        text4.setVerticalAlignment(SwingConstants.CENTER);
        text4.setFont(new Font("bahnschrift", 0, 15));
        add(text4);
        JLabel text5 = new JLabel();
        text5.setText("Recargo por hrs dominic. fest. noche: $" + String.format("%.02f", val3));
        text5.setHorizontalAlignment(SwingConstants.LEFT);
        text5.setVerticalAlignment(SwingConstants.CENTER);
        text5.setFont(new Font("bahnschrift", 0, 15));
        add(text5);
        JLabel text6 = new JLabel();
        text6.setText("Horas extras dia: " + String.format("%.02f", hr4));
        text6.setHorizontalAlignment(SwingConstants.LEFT);
        text6.setVerticalAlignment(SwingConstants.CENTER);
        text6.setFont(new Font("bahnschrift", 0, 15));
        add(text6);
        JLabel text7 = new JLabel();
        text7.setText("Recargo por horas extras dia: $" + String.format("%.02f", val4));
        text7.setHorizontalAlignment(SwingConstants.LEFT);
        text7.setVerticalAlignment(SwingConstants.CENTER);
        text7.setFont(new Font("bahnschrift", 0, 15));
        add(text7);
        JLabel text8 = new JLabel();
        text8.setText("Horas extras noche: " + String.format("%.02f", hr5));
        text8.setHorizontalAlignment(SwingConstants.LEFT);
        text8.setVerticalAlignment(SwingConstants.CENTER);
        text8.setFont(new Font("bahnschrift", 0, 15));
        add(text8);
        JLabel text9 = new JLabel();
        text9.setText("Recargo por horas extras noche: $" + String.format("%.02f", val5));
        text9.setHorizontalAlignment(SwingConstants.LEFT);
        text9.setVerticalAlignment(SwingConstants.CENTER);
        text9.setFont(new Font("bahnschrift", 0, 15));
        add(text9);
        JLabel text10 = new JLabel();
        text10.setText("Horas extras festivas dia: " + String.format("%.02f", hr6));
        text10.setHorizontalAlignment(SwingConstants.LEFT);
        text10.setVerticalAlignment(SwingConstants.CENTER);
        text10.setFont(new Font("bahnschrift", 0, 15));
        add(text10);
        JLabel text11 = new JLabel();
        text11.setText("Recargo por hrs extras fest. dia: $" + String.format("%.02f", val6));
        text11.setHorizontalAlignment(SwingConstants.LEFT);
        text11.setVerticalAlignment(SwingConstants.CENTER);
        text11.setFont(new Font("bahnschrift", 0, 15));
        add(text11);
        JLabel text12 = new JLabel();
        text12.setText("Horas extras festivas noche: " + String.format("%.02f", hr7));
        text12.setHorizontalAlignment(SwingConstants.LEFT);
        text12.setVerticalAlignment(SwingConstants.CENTER);
        text12.setFont(new Font("bahnschrift", 0, 15));
        add(text12);
        JLabel text13 = new JLabel();
        text13.setText("Recargo por hrs extras fest. noche: $" + String.format("%.02f", val7));
        text13.setHorizontalAlignment(SwingConstants.LEFT);
        text13.setVerticalAlignment(SwingConstants.CENTER);
        text13.setFont(new Font("bahnschrift", 0, 15));
        add(text13);
        JLabel text14 = new JLabel();
        text14.setText("Bonficaciones: $" + String.format("%.02f", val8));
        text14.setHorizontalAlignment(SwingConstants.LEFT);
        text14.setVerticalAlignment(SwingConstants.CENTER);
        text14.setFont(new Font("bahnschrift", 0, 15));
        add(text14);
        JLabel text15 = new JLabel();
        text15.setText("Aux de transporte: $" + String.format("%.02f", val9));
        text15.setHorizontalAlignment(SwingConstants.LEFT);
        text15.setVerticalAlignment(SwingConstants.CENTER);
        text15.setFont(new Font("bahnschrift", 0, 15));
        add(text15);

    }
}

/**
 * JPanelContentDeductions
 */
class JPanelContentDeductions extends JPanel {

    public JPanelContentDeductions(int width, int height, double aporEps, double aporPension, double cuotaPrestamo) {
        this.setBounds((int) ((width * 0.5 / 2) + 65), (int) (height * 0.17), (int) (width * 0.5 / 2) - 70,
                (int) (height * 0.466 / 2));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(4, 1));

        JLabel text = new JLabel();
        text.setText("Aporte a EPS: $" + String.format("%.03f", aporEps));
        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 15));
        add(text);

        JLabel text1 = new JLabel();
        text1.setText("Aporte a Pension: $" + String.format("%.03f", aporPension));
        text1.setHorizontalAlignment(SwingConstants.LEFT);
        text1.setVerticalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("bahnschrift", 0, 15));

        add(text1);
        JLabel text2 = new JLabel();
        text2.setText("Cuota de prestamos: $" + String.format("%.03f", cuotaPrestamo));
        text2.setHorizontalAlignment(SwingConstants.LEFT);
        text2.setVerticalAlignment(SwingConstants.CENTER);
        text2.setFont(new Font("bahnschrift", 0, 15));
        add(text2);

        JLabel text3 = new JLabel();
        text3.setText("Total Deducciones: -$" + String.format("%.03f", aporEps + aporPension + cuotaPrestamo));
        text3.setHorizontalAlignment(SwingConstants.LEFT);
        text3.setVerticalAlignment(SwingConstants.CENTER);
        text3.setFont(new Font("bahnschrift", 0, 15));
        add(text3);
    }
}

/**
 * JPanelImageDductions
 */
class JPanelImageDductions extends JPanel {

    public JPanelImageDductions(int width, int height) {

        this.setBackground(Color.white);
        setLayout(new GridLayout(1, 1));
        this.setBounds((int) ((width * 0.5 / 2) + 55), (int) (height * 0.17) + (int) (height * 0.466 / 2),
                (int) (width * 0.5 / 2) - 70, (int) (height * 0.466 / 2));

        Image img = new ImageIcon("ejercicios_java_parcial_1/ejercicio_4/assets/deduction.png").getImage();
        ImageIcon img2 = new ImageIcon(
                img.getScaledInstance((int) (width * 0.5 / 2) - 70, (int) (height * 0.466 / 2), Image.SCALE_SMOOTH));

        JLabel picLabel = new JLabel(img2);

        add(picLabel);
    }

}

/**
 * JPanelFooter
 */
class JPanelFooterResult extends JPanel {
    public JPanelFooterResult(int width, int height, String nombre, Double val1, Double val2, Double val3) {
        this.setBounds(20, (int) (height * 0.586) + 70, (int) (width * 0.5) - 50, (int) (height * 0.15));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(4, 1));
        JLabel text1 = new JLabel();
        text1.setText("Nombre: " + nombre);
        text1.setHorizontalAlignment(SwingConstants.LEFT);
        text1.setVerticalAlignment(SwingConstants.CENTER);
        text1.setFont(new Font("bahnschrift", 0, 15));
        add(text1);

        JLabel text2 = new JLabel();
        text2.setText("Total Aux por recargo " + String.format("%.02f", val1));
        text2.setHorizontalAlignment(SwingConstants.LEFT);
        text2.setVerticalAlignment(SwingConstants.CENTER);
        text2.setFont(new Font("bahnschrift", 0, 15));
        add(text2);

        JLabel text3 = new JLabel();
        text3.setText("Total salario neto " + String.format("%.02f", val2));
        text3.setHorizontalAlignment(SwingConstants.LEFT);
        text3.setVerticalAlignment(SwingConstants.CENTER);
        text3.setFont(new Font("bahnschrift", 0, 15));
        add(text3);

        JLabel text4 = new JLabel();
        text4.setText("Total salario Devengado " + String.format("%.02f", val3));
        text4.setHorizontalAlignment(SwingConstants.LEFT);
        text4.setVerticalAlignment(SwingConstants.CENTER);
        text4.setFont(new Font("bahnschrift", 0, 15));
        add(text4);

    }

}

/**
 * DividerResult
 */
class DividerResult extends JPanel {
    public DividerResult(int width, int height, int boundY, int heightSize, int widthSize) {
        this.setBounds((int) ((width * 0.5 / 2) + 50) - (widthSize / 2), boundY, widthSize, heightSize);
        this.setBackground(Color.gray);
        this.setLayout(null);
    }
}
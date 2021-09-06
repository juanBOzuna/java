package ejercicio_joptionpane_5;

import javax.swing.JOptionPane;

public class CmAOtrasMedidas {
    public static void main(String[] args) {
        double cm = 0, km = 0, m = 0, milla = 0, mm = 0, pie = 0, pulg = 0, yarda = 0;
        Boolean validador = true;
        while (validador) {
            try {
                cm = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de centimetros"));
                validador = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser solo numeros");
            }
        }

        mm = cm * 10;
        pulg = cm / 2.54;
        pie = pulg / 12;
        m = cm * 0.01;
        yarda = pulg / 36;
        milla = (m * 0.001) * 0.621371;

        String ms = "" + cm + " centimetros son :" + "\n" + "" + "\n" + mm + " MILIMETROS, " + "\n"
                + String.format("%.03f", pulg) + " PULGADAS, " + "\n" + String.format("%.03f", pie) + " PIES, " + "\n"
                + String.format("%.03f", m) + " METROS , " + "\n" + String.format("%.03f", yarda) + " YARDAS, " + "\n"
                + String.format("%.03f", milla) + " MILLAS.";

        JOptionPane.showMessageDialog(null, ms);

    }
}
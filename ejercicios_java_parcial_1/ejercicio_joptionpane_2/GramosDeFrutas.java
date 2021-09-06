package ejercicio_joptionpane_2;

import javax.swing.JOptionPane;

public class GramosDeFrutas {
    public static void main(String[] args) {
        int edad = 0, vueltas = 0;
        double g = 0, manzanas = 0, kg = 0;

        Boolean validador = true;

        while (validador) {
            try {
                edad = Integer.parseInt(JOptionPane.showInputDialog("Cuantos anios tiene"));
                validador = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser solo numeros");
            }
        }

        kg = edad * 8;
        g = kg * 1000;
        manzanas = g / 4;

        JOptionPane.showMessageDialog(null, "Usted ha consumido aproximadamente " + g + " gr de frutas, lo que serian "
                + manzanas + " manzanas en total");

    }
}

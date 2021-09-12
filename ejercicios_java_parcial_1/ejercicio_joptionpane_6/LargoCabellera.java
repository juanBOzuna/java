package ejercicios_java_parcial_1. ejercicio_joptionpane_6;

import javax.swing.JOptionPane;

public class LargoCabellera {
    public static void main(String[] args) {
        double cm = 0, metros = 0;
        int edad = 0;
        boolean validador = true;

        while (validador) {
            try {
                edad = Integer.parseInt(JOptionPane.showInputDialog("Digite su edad"));
                validador = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser solo numeros");
            }
        }

        metros = ((edad * 360) / 30) * 4;

        JOptionPane.showMessageDialog(null, "su pelo asumiendo que nunca se lo ha cortado deberia medir "
                + String.format("%.02f", metros).replace(".", ",") + " metros");

    }
}

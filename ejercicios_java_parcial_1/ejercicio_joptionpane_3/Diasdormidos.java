package ejercicios_java_parcial_1. ejercicio_joptionpane_3;

import javax.swing.JOptionPane;

public class Diasdormidos {
    public static void main(String[] args) {
        int act = 0;
        int dias = 0;
        int edad = 0;
        int nac = 0;
        String nombre;
        boolean validador = true;

        nombre = JOptionPane.showInputDialog("Escriba su nombre");

        while (validador) {
            try {
                nac = Integer.parseInt(JOptionPane.showInputDialog("Digite el anio de nacimieno"));
                validador = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser solo numeros");
            }
        }
        validador = true;
        while (validador) {
            try {
                act = Integer.parseInt(JOptionPane.showInputDialog("Digite el anio actual"));
                validador = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser solo numeros");
            }
        }

        edad = (act - nac) * 360;
        dias = ((edad * 34) / 100);
        System.out.print("actual: " + act + " nacimiento" + nac);

        JOptionPane.showMessageDialog(null, "Usted ha dormido aproximadamente " + dias + " DIAS");
    }

}

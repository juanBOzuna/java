package ejercicios_java_parcial_1. ejercicio_joptionpane_1;

import javax.swing.JOptionPane;

public class CapturarDatos {
    public static void main(String[] args) {
        String nombre;
        int edad = 0;
        double estatura = 0;
        Boolean validador = true;

        nombre = JOptionPane.showInputDialog(null, "Digite su nombre");
        while (validador) {
            try {
                edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su Edad"));
                validador = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser solo numeros");
            }
        }

        validador = true;

        while (validador) {
            try {

                estatura = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite su Estatura en metros")) ;
                validador = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser solo numeros");
            }

        }

        String message = "Usted se llama " + nombre + ", Tienes " + edad + " anios" + " y mides " + estatura
                + " metros";
        JOptionPane.showMessageDialog(null, message);
    }
}

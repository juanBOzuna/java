package ejercicio_joptionpane_4;

import javax.swing.JOptionPane;

public class GramosAOtrasMedidas {
    public static void main(String[] args) {
        double cg = 0, dag = 0, dg = 0, gr = 0, hg = 0, kg = 0, lb = 0, mg = 0, onza = 0, t = 0;
        Boolean validador = true;
        while (validador) {
            try {
                gr = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de gramos"));
                validador = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser solo numeros");
            }
        }

        mg = gr * 1000;
        hg = gr * 0.01;
        kg = hg * 0.1;
        dg = gr * 10;
        cg = dg * 10;
        lb = kg * 2.20462;
        dag = gr * 0.1;
        t = kg / 1000;
        onza = dag * 0.35274;

        String ms = "" + String.format("%.03f", mg) + " miligramos" + "\n" + String.format("%.03f", hg) + " hectogramos"
                + "\n" + String.format("%.03f", kg) + " kilogramos" + "\n" + String.format("%.03f", dg) + " decigramos"
                + "\n" + String.format("%.03f", cg) + " centigramos" + "\n" + String.format("%.03f", lb) + " libras "
                + "\n" + String.format("%.03f", dag) + " decagramos" + "\n" + String.format("%.03f", t) + " toneladas"
                + "\n" + String.format("%.03f", onza) + " onzas" + "\n";

        JOptionPane.showMessageDialog(null, ms);
    }
}

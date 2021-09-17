package ejercicios_java.ejercicio_2;
import java.awt.*;

import javax.swing.*;

import ejercicios_java.utils.MethodForExapmle;
import ejercicios_java.utils.Ventanas;

import java.awt.event.*;

public class Ventana2 extends Ventanas{

    public Ventana2(){
        setTitle("Calcular Area De rectangulo");
        setLayout(new GridLayout(15, 4));
        initComponents();
    }

    private void initComponents(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        final JLabel etiqueta =  new JLabel();
        MethodForExapmle.etiquetar(etiqueta, panel, "juan");

        final JLabel base = new JLabel();
        final JLabel altura = new JLabel();
        final JLabel vacio = new JLabel();
        final JLabel resultado = new JLabel();
        final JLabel resultadoMtrs = new JLabel();
        final JLabel resultadoCm = new JLabel();
        final JLabel resultadoMm = new JLabel();
        final JTextField campoAltura = new JTextField();
        final JTextField campoBase = new JTextField();
        final JButton button = new JButton();

        MethodForExapmle.etiquetar(altura, panel, "Ingrese la altura del rectangulo en metros");
        MethodForExapmle.mostrarCampo(campoAltura, panel);
        MethodForExapmle.etiquetar(base, panel, "Ingrese la base del rectangulo en metros");
        MethodForExapmle.mostrarCampo(campoBase, panel);
        MethodForExapmle.sizedBox(panel, vacio);
        MethodForExapmle.mostraBotonRadius(panel, button);
        MethodForExapmle.etiquetar(resultado, panel, "");
        MethodForExapmle.etiquetar(resultadoMm, panel, "");
        MethodForExapmle.etiquetar(resultadoCm, panel, "");
        MethodForExapmle.etiquetar(resultadoMtrs, panel, "");

        button.addActionListener(new ActionListener() {
            Functions f = new Functions();
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    f.calcular(campoAltura,campoBase,resultado,resultadoCm,resultadoMm,resultadoMtrs, panel );
                } catch (Exception e) {
                    resultado.setText("Error: "+e);
                }
            }
        });
    
    }
    
}

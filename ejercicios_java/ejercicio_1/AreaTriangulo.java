package ejercicios_java.ejercicio_1;
import java.awt.event.*;
import javax.swing.*;

import ejercicios_java.utils.*;

public class AreaTriangulo {
	public static void main(String arg[]) {
		Functions f = new Functions();
		Window ventana = new Window();

		final JLabel vacio = new JLabel();
		final JLabel altura = new JLabel();
		final JTextField campoAltura = new JTextField();
		final JLabel base = new JLabel();
		final JTextField campoBase = new JTextField();
		final JLabel resultado = new JLabel();
		final JLabel resultadoMtrs = new JLabel();
		final JLabel resultadoCm = new JLabel();
		final JLabel resultadoMm = new JLabel();
		JButton calcular = new JButton();

		Methods.etiquetar(altura, ventana, "Altura del triangulo en mm: ");
		Methods.mostrarCampo(campoAltura, ventana);
		Methods.etiquetar(base, ventana, "Base del triangulo en mm: ");
		Methods.mostrarCampo(campoBase, ventana);
		Methods.sizedBox(ventana, vacio);
		Methods.mostraBoton(ventana, calcular);
		Methods.etiquetar(resultado, ventana, "");
		Methods.etiquetar(resultadoMm, ventana, "");
		Methods.etiquetar(resultadoCm, ventana, "");
		Methods.etiquetar(resultadoMtrs, ventana, "");

		f.parametersForWindow(ventana);

		calcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				try {
					f.calcular(campoAltura,campoBase,resultado,resultadoCm,resultadoMm,resultadoMtrs, ventana );
				} catch (Exception e) {
					resultado.setText("Error: "+e);
				}
			}
		});
	}

	
}
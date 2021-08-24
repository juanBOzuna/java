package ejercicio_1;
import java.awt.event.*;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.*;
import methods.*;

public class AreaTriangulo {
	public static void main(String arg[]) {

		Ventana ventana = new Ventana();
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

		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

		calcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evento) {
				try {
					calcular(campoAltura,campoBase,resultado,resultadoCm,resultadoMm,resultadoMtrs, ventana );
				} catch (Exception e) {
					resultado.setText("Error: "+e);
				}
			}
		});
	}

	static void calcular(JTextField campoBase ,JTextField campoAltura,JLabel resultado,JLabel mm, JLabel cm, JLabel m, Ventana ventana ){
		double altura = Double.parseDouble(campoAltura.getText().replace(",", ".")  );
		double base= Double.parseDouble(campoBase.getText().replace(",", ".")  );
		double result =  (altura*base)/2;
		double mtr=result * 0.001;
		double cms=result * 0.1;

		Methods.etiquetar(resultado, ventana, "Area del triangulo: ");
		Methods.etiquetar(mm, ventana, "milimetros: "+ result );
		Methods.etiquetar(cm, ventana, "centimetros: "+ cms );
		Methods.etiquetar(m, ventana, "metros: "+ mtr );
		
	}
}
package utils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MethodForExapmle {
    public static void etiquetar(JLabel etiqueta,JPanel ventana,String texto ){
		etiqueta.setText(texto);
		ventana.add(etiqueta);
	}

	public static void SoloEtiquetar(JLabel etiqueta,String texto){
		etiqueta.setText(texto);
	}

	public static void mostrarCampo(JTextField campo,JPanel ventana){
		campo.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.add(campo);
	}

	public static void sizedBox(JPanel ventana, JLabel vacio  ){
		vacio.setText("");
		ventana.add(vacio);
	}

    public	static void mostraBoton(JPanel ventana, JButton button  ){
		button.setText("calcular");
		ventana.add(button);
	}

	public	static void mostraBotonRadius(JPanel ventana, JButton button  ){
		button.setText("calcular");
		ventana.add(button);
	}

}

package ejercicios_java_parcial_1.methods;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Methods {

   public static void etiquetar(JLabel etiqueta,JFrame ventana,String texto ){
		etiqueta.setText(texto);
		ventana.add(etiqueta);
	}

	public static void SoloEtiquetar(JLabel etiqueta,String texto){
		etiqueta.setText(texto);
	}

	public static void mostrarCampo(JTextField campo,JFrame ventana){
		campo.setHorizontalAlignment(SwingConstants.CENTER);
		ventana.add(campo);
	}

	public static void sizedBox(JFrame ventana, JLabel vacio  ){
		vacio.setText("");
		ventana.add(vacio);
	}

    public	static void mostraBoton(JFrame ventana, JButton button  ){
		button.setText("calcular");
		ventana.add(button);
	}

	public	static void mostraBotonRadius(JFrame ventana, JButton button  ){
		button.setText("calcular");
		ventana.add(button);
	}

}

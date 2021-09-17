package ejercicios_java.ejercicio_1;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ejercicios_java.utils.*;

public class Functions{
    
    protected void calcular(JTextField campoBase ,JTextField campoAltura,JLabel resultado,JLabel mm, JLabel cm, JLabel m, Window ventana ){
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


	void parametersForWindow(Window ventana){
		ventana.setTitle("title");
		ventana.setVisible(true);
	}

}

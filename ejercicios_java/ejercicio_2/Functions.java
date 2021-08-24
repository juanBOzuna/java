package ejercicio_2;
import methods.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Functions{
    
  protected static void calcular(JTextField campoAltura, JTextField campoBase, JLabel resultado, JLabel cm,
  JLabel mm, JLabel m, Ventana2 ventana) {
  double altura = Double.parseDouble(campoAltura.getText().replace(",", ".")  );
  double base= Double.parseDouble(campoBase.getText().replace(",", ".")  );
  double result =  altura*base;
  double mms=result * 1000;
  double cms=result * 100;
  Methods.etiquetar(resultado, ventana, "Area del triangulo: ");
  Methods.etiquetar(mm, ventana, "milimetros: "+ mms );
  Methods.etiquetar(cm, ventana, "centimetros: "+ cms );
  Methods.etiquetar(m, ventana, "metros: "+ result );    
}
}

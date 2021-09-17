package ejercicios_java.ejercicio_2;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import ejercicios_java.utils.*;

public class Functions{
    
  protected  void calcular(JTextField campoAltura, JTextField campoBase, JLabel resultado, JLabel cm,
  JLabel mm, JLabel m, JPanel ventana) {
  double altura = Double.parseDouble(campoAltura.getText().replace(",", ".")  );
  double base= Double.parseDouble(campoBase.getText().replace(",", ".")  );
  double result =  altura*base;
  double mms=result * 1000;
  double cms=result * 100;
  MethodForExapmle.etiquetar(resultado, ventana, "Area del triangulo: ");
  MethodForExapmle.etiquetar(mm, ventana, "milimetros: "+ mms );
  MethodForExapmle.etiquetar(cm, ventana, "centimetros: "+ cms );
  MethodForExapmle.etiquetar(m, ventana, "metros: "+ result );    
}
}

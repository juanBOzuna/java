package ejercicio_gui_3;

public class OrdenarNumeros {
  static Ventana v2 = new Ventana();
  public static void main(String[] args) {
      Ventana v = new Ventana();
      v.setVisible(true);
      v2.setVisible(false);
  }  


  public void showResult(boolean val ){
    v2.setVisible(val);
  }
}

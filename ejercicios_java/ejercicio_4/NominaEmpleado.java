package ejercicio_4;
import javax.swing.JFrame;

public class NominaEmpleado extends JFrame{
    static Ventana v2 = new Ventana(JFrame.HIDE_ON_CLOSE,Ventana.WINDOW_RESULT );
    static boolean stauts = false;
    public static void main(String[] args) {
      Ventana v = new Ventana(JFrame.EXIT_ON_CLOSE,!Ventana.WINDOW_RESULT);
      v.setVisible(true);
      v2.setVisible(false);
    }

    public void showResult(boolean val ){
        stauts=val;
        v2.setVisible(stauts);
      }
}

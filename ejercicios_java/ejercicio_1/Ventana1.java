package ejercicio_1;
import javax.swing.JFrame;
import java.awt.*;

public class Ventana1 extends JFrame {

    public Ventana1(){
        this.setSize(500, 500);
		this.setTitle("Calcular Area De Triangulo");
        this.setLayout(new GridLayout(13, 0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

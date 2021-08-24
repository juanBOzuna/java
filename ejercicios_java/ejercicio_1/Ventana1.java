package ejercicio_1;
import javax.swing.JFrame;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(){
		this.setTitle("Calcular Area De Triangulo");
        this.setLayout(new GridLayout(15, 4));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

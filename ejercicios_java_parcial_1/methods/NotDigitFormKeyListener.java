package methods;

import java.awt.event.*;

public class NotDigitFormKeyListener extends KeyAdapter{

    public void keyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter)) {
            evt.consume(); 
        }
    }
}

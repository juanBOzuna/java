package ejercicio_GUI_5;

import java.awt.event.*;

public class DigitOnlyFormKeyListener extends KeyAdapter {

    public void keyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && (caracter != '.')
                && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
            evt.consume();
        }
    }
}

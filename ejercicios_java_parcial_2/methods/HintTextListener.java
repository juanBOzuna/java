package methods;

import java.awt.event.*;
import java.awt.event.FocusAdapter;

import javax.swing.JTextField;

public class HintTextListener extends FocusAdapter {
    JTextField form = new JTextField();
    String titleGeneral;

    public HintTextListener(JTextField f, String t) {
        form = f;
        titleGeneral = t;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (form.getText().equals(titleGeneral)) {
            form.setText("");
        } else {
            form.setText(form.getText());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (form.getText().equals(titleGeneral) || form.getText().length() == 0) {
            form.setText(titleGeneral);
        } else {
            form.setText(form.getText());
        }
    }
}

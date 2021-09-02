package ejercicio_4;

import java.awt.event.*;
import javax.swing.*;

import java.awt.*;

public class Ventana extends JFrame {
    static boolean showVentana = true;
    static boolean WINDOW_RESULT =true;
    public Ventana(int operationClose,boolean pageResult ) {
        setLayout(null);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setBackground(Color.white);
        setSize((int) (width * 0.5), (int) (height * 0.8));
        setDefaultCloseOperation(operationClose);
        
            JPanel panePrincipal = new JPanel();
            panePrincipal.setSize((int) (width * 0.5), (int) (height * 0.8));
            panePrincipal.setBackground(Color.white);
            panePrincipal.setLayout(null);
            add(panePrincipal);

        if(!pageResult){
            JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height,"Nomina de empleados");
            panePrincipal.add(titleHeader);
    
            JpanelButton button = new JpanelButton((int) (width * 0.3), height);
            panePrincipal.add(button);


        }else{
            JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height,"Resultados");
            panePrincipal.add(titleHeader);
        }
    }
}


/**
 * JpanelHeaderTitle
 */
class JpanelHeaderTitle extends JPanel {
    public JpanelHeaderTitle(int width, int height,String title) {
        this.setBounds(155, 5, (int) (width * 0.3 - 60), (int) (height * 0.10));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2, 1));
        // this.setSize(width, height);

        JLabel text = new JLabel();
        text.setText(title);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("britannic bold", 0, 31));
        text.setVisible(false);
        add(text);
    }
}

/**
 * JpanelButton
 */
class JpanelButton extends JPanel {
    public JpanelButton(int height, int width) {
        this.setBounds(0, 180, width, 150);
        this.setBackground(Color.white);
        this.setLayout(null);
        JButton button = new JButton("ORDENAR");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(105, 10, 100, 50);
        buttonPanel.add(button);
        buttonPanel.setBackground(Color.white);
        add(buttonPanel);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    if (!NominaEmpleado.stauts) {
                        NominaEmpleado n = new NominaEmpleado();
                        n.showResult(Ventana.showVentana);
                        NominaEmpleado.v2.addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent evt) {
                                NominaEmpleado.stauts = false;
                            }
                        });
                    }
                } catch (Exception e) {
                }
            }
        });
    }
}

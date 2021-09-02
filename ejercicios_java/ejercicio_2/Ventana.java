package ejercicio_2;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(){
        setLayout(null);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setBackground(Color.white);
        setSize( (int)(width*0.3) ,(int) (height/2.8));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panePrincipal = new JPanel();
        panePrincipal.setSize((int)(width*0.3) ,(int) (height/2.5));
        panePrincipal.setBackground(Color.white);
        panePrincipal.setLayout(null);
        add(panePrincipal);

        JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width,height);
        panePrincipal.add(titleHeader);
        
        JFormattedTextField formALtura = new JFormattedTextField(new Integer(0));
        JpanelTexFormWidth texFormAltura = new JpanelTexFormWidth(width,height,formALtura);
        panePrincipal.add(texFormAltura);
       
        JFormattedTextField formBase = new JFormattedTextField (new Integer(0));
        JpanelTextFormLarge texFormBase = new JpanelTextFormLarge(width,height,formBase);
        panePrincipal.add(texFormBase);
      
        JpanelButton button = new JpanelButton((int)(width*0.3),height,formALtura,formBase);
        panePrincipal.add(button);

    }
}



/**
 * JpanelHeaderTitle
 */
class JpanelHeaderTitle extends JPanel {
    public JpanelHeaderTitle(int width, int height) {
        this.setBounds(20, 5, (int)(width*0.3 -60 ),(int)(height*0.10));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2,1) );
        // this.setSize(width, height);

         JLabel text = new JLabel();
         text.setText("Area de un Rectangulo");
         text.setHorizontalAlignment(SwingConstants.CENTER );
         text.setVerticalAlignment(SwingConstants.BOTTOM);
         text.setFont(new Font("britannic bold",0,31) );
         add(text);
     
         JLabel subText = new JLabel();
         subText.setHorizontalAlignment(SwingConstants.CENTER );
         subText.setVerticalAlignment(SwingConstants.TOP);
         subText.setText("Resultados en m cm y mm cuadrados");
         subText.setFont(new Font("abadi",0,10) );
         add(subText);
    }
}

/**
 * JpanelTexFormAltura
 */ 
class JpanelTexFormWidth extends JPanel {
    public JpanelTexFormWidth(int width, int height,JTextField form ) {
        this.setBounds(20, (int)(height*0.10)-15 , (int)(width*0.135-20 ),(int)(height*0.13));
        this.setBackground(Color.white);
        this.setLayout(null );
        
        JLabel text = new JLabel();
        text.setText("Ancho en metros");
        text.setHorizontalAlignment(SwingConstants.CENTER );
        
        text.setFont(new Font("abadi",2,15) );
        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 25, (int)(width*0.135-20 ),30 );
        textPanel.add(text );
        textPanel.setBackground(Color.white);
        add(textPanel);

        form.setSize((int)(width*0.135-20 ),20);
        form.setBounds(0,65,(int)(width*0.135-20 ),20);
        form.setHorizontalAlignment(SwingConstants.CENTER);
        // text.setFont(new Font("abadi",2,15) );
        add(form);
    
    }
}

/**
 * JpanelTextFormBase
 */ 
class JpanelTextFormLarge extends JPanel {
    public JpanelTextFormLarge(int width, int height,JTextField form ) {
        this.setBounds((int)(width*0.135-20 )+40, (int)(height*0.10)-15 , (int)(width*0.135-20 ),(int)(height*0.13));
        this.setBackground(Color.white);
        this.setLayout(null );

        
        JLabel text = new JLabel();
        text.setText("Largo en metros");
        text.setHorizontalAlignment(SwingConstants.CENTER );
        text.setFont(new Font("abadi",2,15) );

        JPanel textPanel = new JPanel();
        textPanel.setBounds(0, 25, (int)(width*0.135-20 ),30 );
        textPanel.add(text );
        textPanel.setBackground(Color.white);
        add(textPanel);

        form.setSize((int)(width*0.135-20 ),20);
        form.setBounds(0,65,(int)(width*0.135-20 ),20);
        form.setHorizontalAlignment(SwingConstants.CENTER);
        add(form);
    }
}


/**
 * JpanelButton
 */ 
class JpanelButton extends JPanel {
    public JpanelButton(int height,int width,JTextField fAltura,JTextField fBase  ){
        this.setBounds(0,180 , width ,150 );
        
        // ColorUIResource colorAttribute = new ColorUIResource(0, 124, 124);
        this.setBackground(Color.white);
        this.setLayout(null );
        JButton button = new JButton("Calcular");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(140, 0, 100,50 );
        buttonPanel.add(button );
        buttonPanel.setBackground(Color.white );
        add(buttonPanel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    double altura = Double.parseDouble(fAltura.getText().replace(",", ".") );
                    double base= Double.parseDouble(fBase.getText().replace(",", ".")  );
                    double result =  altura*base;
                    double mm=result * 1000;
                    double cms=result * 100;
                    String mensage = "Metros: "+Double.toString(result)+"  \nCentimetros:  "+Double.toString(cms)+"\nMilimetros: " +Double.toString(mm);
                        JOptionPane.showMessageDialog(null ,mensage , "Area en las siguientes medidas", 1);
                   
                } catch (Exception e) {
                    // resultado.setText("Error: "+e);
                }
            }
        });
    }
}

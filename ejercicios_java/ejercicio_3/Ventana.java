package ejercicio_3;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;

public class Ventana extends JFrame {
    
    public Ventana(){
        this.setSize(450, 300);
        setTitle("title");
        initComponents();
    }

    private void initComponents(){
        // JLabel vacio = new JLabel("s ");

        JPanel content =  new JPanel();
        content.setSize(500, 200);
        content.setBackground(Color.white);
        content.setLayout(new GridLayout(3, 1));
   


        NorthContent northContent = new NorthContent();

        SouthContent southContent = new SouthContent();
        
        CenterContent centerContent = new CenterContent();

      
        this.getContentPane().add(northContent,BorderLayout.NORTH  );
        this.getContentPane().add(centerContent, BorderLayout.CENTER);
        this.getContentPane().add(southContent,BorderLayout.SOUTH );
    }


}


class NorthContent extends JPanel{
  public NorthContent(){
    this.setBackground(Color.white);
    this.setLayout(new GridLayout(2,1) );
 
     JLabel text = new JLabel();
     text.setText("Area de un triangulo");
     text.setHorizontalAlignment(SwingConstants.CENTER );
     text.setVerticalAlignment(SwingConstants.BOTTOM);
     text.setFont(new Font("britannic bold",0,32) );
     add(text);
 
     JLabel subText = new JLabel();
     subText.setHorizontalAlignment(SwingConstants.CENTER );
     subText.setVerticalAlignment(SwingConstants.TOP);
     subText.setText("Resultados en mm cm y m");
     subText.setFont(new Font("abadi",0,10) );
     add(subText);
  }
}


class SouthContent extends JPanel{

    public SouthContent(){
        
        setBackground(Color.white);
        JButton button = new JButton("Calcular ");
        Border line = new LineBorder(Color.white);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
  
       add(button);
    }

}


class CenterContent extends JPanel{

    public CenterContent(){
      setLayout(new  GridLayout(1,2) );
      setBackground(Color.black );
      JLabel vacio = new JLabel();

      JButton btn1 = new JButton();
      JButton btn2 = new JButton();
      JButton btn3 = new JButton();
      JButton btn4 = new JButton();

      AlturaContent altura = new AlturaContent();
      BaseContent base = new BaseContent();


      add(altura);
      add(base);

    }

}

class AlturaContent extends JPanel{

    public AlturaContent(){
        
    this.setLayout(new GridLayout(3,1) );
    setBackground(Color.white );

    JLabel vacio = new JLabel(" s");
    JLabel Titulo = new JLabel("Altura (mm)");
    
    Titulo.setHorizontalAlignment(SwingConstants.CENTER );
    Titulo.setVerticalAlignment(SwingConstants.CENTER);
    Titulo.setFont(new Font("britannic bold",0,15) );
    // JTextField capoAltura = new JTextField();
    DividerTextForm campoAltura = new DividerTextForm();
    add(Titulo);
    add(campoAltura);

    }

}

class DividerTextForm extends JPanel{

    public DividerTextForm(){
            
    this.setLayout(new GridLayout(2,1) );
    setBackground(Color.white );

    JTextField campoAltura = new JTextField();
    // campoAltura.setColumns(5);
    JLabel vacio = new JLabel(" ");
    add(campoAltura);

    add(vacio);
    
    }
}

class BaseContent extends JPanel{

    public BaseContent(){
        
    this.setLayout(new GridLayout(3,1) );
    setBackground(Color.white );

    JLabel vacio = new JLabel(" s");
    JLabel Titulo = new JLabel("Base (mm)");
    
    Titulo.setHorizontalAlignment(SwingConstants.CENTER );
    Titulo.setVerticalAlignment(SwingConstants.CENTER);
    Titulo.setFont(new Font("britannic bold",0,15) );
    // JTextField capoAltura = new JTextField();
    DividerTextFormBase campoAltura = new DividerTextFormBase();
    add(Titulo);
    add(campoAltura);

    }

}

class DividerTextFormBase extends JPanel{

    public DividerTextFormBase(){
            
    this.setLayout(new GridLayout(2,1) );
    setBackground(Color.white );

    JTextField campoAltura = new JTextField();
    // campoAltura.setColumns(5);
    JLabel vacio = new JLabel(" ");
    add(campoAltura);

    add(vacio);
    
    }
}
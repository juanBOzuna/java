package ejercicio_5;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame {
    int idJugador = 0;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    Result result = new Result();
    JButton boton2 = new JButton();

    public Ventana() {
        setSize(width / 3, height / 4);
        setTitle("Lanzar 50 veces dos dados");

        JPanel panelp = new JPanel();
        panelp.setSize(width / 3, height / 4);
        panelp.setBackground(Color.white);
        panelp.setLayout(null);
        JPanel panelButton = new JPanel();
        panelButton.setBounds((int) ((height * 0.029)), (int) (height * 0.064), (int) (width * 0.29), 50);
        panelButton.setBackground(Color.WHITE);
        panelButton.setLayout(null);

        JButton boton1 = new JButton();
        boton1.setText("Jugar");
        boton1.setBounds(0, 0, (int) (width * 0.13), 30);

        boton2.setText("Finalizar");
        boton2.setBounds((int) (width * 0.13) + (int) (width * 0.03), 0, (int) (width * 0.13), 30);

        panelButton.add(boton1);
        panelButton.add(boton2);

        // if (validate) {
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                boton1.setEnabled(false);
                setStatusFinish(false);
                idJugador++;

                Player player = new Player(idJugador);
                for (int i = 0; i < 15; i++) {
                    Launching launching = new Launching(i);
                    player.setLaunching(launching);
                }
                player.calculateAlldata();
                saveResult(player);

                Ventana2 ventana2 = new Ventana2(player);
                ventana2.setVisible(true);
                ventana2.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent evt) {
                        boton1.setEnabled(true);
                        setStatusFinish(true);
                    }
                });
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                callBack();
            }
        });
        panelp.add(panelButton);
        add(panelp);
    }

    void saveResult(Player player) {
        this.result.setPlayers(player);
    }

    void setStatusFinish(Boolean b) {
        boton2.setEnabled(b);
    }

    void callBack() {
        result.calculateAllData();
        System.out.println("Participante con mas Dobles: #" + result.getPlayerWithMostRepeatedLaunchings());
        System.out.println("\nParticipante con mas parejas repetidas: #" + result.getPlayerWithMostEqualDouble());
    }
}

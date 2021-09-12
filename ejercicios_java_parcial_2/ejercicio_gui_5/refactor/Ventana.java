package ejercicios_java_parcial_2.ejercicio_gui_5.refactor;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame {
    int idJugador = 0;
    int totalPlayers = 0;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    Boolean digitOnly = true;
    Result result = new Result();
    JButton boton2 = new JButton();
    JButton boton1 = new JButton();
    JLabel title = new JLabel();

    public Ventana() {

        while (digitOnly) {
            try {

                totalPlayers = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite cuantos jugadores lanzaran"));
                digitOnly = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");
            }
        }

        setSize(width / 3, (int) (height * 0.40));
        setTitle("Lanzar 50 veces dos dados");

        JPanel panelp = new JPanel();
        panelp.setSize(width / 3, (int) (height * 0.40));
        panelp.setBackground(Color.white);
        panelp.setLayout(null);

        JpanelHeaderTitle titleHeader = new JpanelHeaderTitle(width, height, title);
        panelp.add(titleHeader);

        JPanel panelButton = new JPanel();
        panelButton.setBounds((int) ((height * 0.029)), (int) (height * 0.18), (int) (width * 0.29), 50);
        panelButton.setBackground(Color.WHITE);
        panelButton.setLayout(null);
        if (idJugador == 0)
            boton1.setText("Jugador #1");
        boton1.setBounds(0, 0, (int) (width * 0.13), 30);

        boton2.setText("Finalizar");
        boton2.setEnabled(false);
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
                for (int i = 0; i < 50; i++) {
                    Launching launching = new Launching(i);
                    player.setLaunching(launching);
                }
                player.calculateAlldata();
                saveResult(player);

                Ventana2 ventana2 = new Ventana2(player);
                ventana2.setVisible(true);
                ventana2.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent evt) {

                        if (player.getId() >= getTotalPlayers()) {
                            boton1.setEnabled(false);
                            setStatusFinish(true);
                        } else {
                            setIdJugador(player.getId());

                            setTitleButton1("Jugador #" + (player.getId() + 1));
                            boton1.setEnabled(false);
                            boton1.setEnabled(true);
                        }
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

    void setTitleButton1(String text) {
        this.boton1.setText(text);
    }

    void callBack() {
        result.calculateAllData();
        System.out.println("\nParticipante con mas Dobles: Jugador #" + result.getPlayerWithMostEqualDouble());
        System.out.println(
                "Participante con mas parejas repetidas: Jugador #" + result.getPlayerWithMostRepeatedLaunchings());
        System.out.println("Cantidad de jugadores que perdieron: " + result.getLosersAmount());
        System.out.println( result.getWinner()==0 ?"Nadie gano porque todos sacaron doble 1":  "Ganador:  Jugador #" + result.getWinner());
        System.out.println("Perdedor:  Jugador #" + result.getLoser());
    }

    int getTotalPlayers() {
        return totalPlayers;
    }

    void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }
}

/**
 * JpanelHeaderTitle
 */
class JpanelHeaderTitle extends JPanel {
    public JpanelHeaderTitle(int width, int height, JLabel text) {
        this.setBounds(0, 20, width / 3, (int) (height * 0.10));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2, 1));
        // this.setSize(width, height);
        text.setText("Lanzamiento de dos dados");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("britannic bold", 0, 28));
        add(text);
    }
}

package ejercicios_java_parcial_2.ejercicio_gui_6.refactor;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame {
    int idJugador = 0;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    Boolean digitOnly = true;
    Result result = new Result();
    JButton boton2 = new JButton();
    JButton boton1 = new JButton();
    JLabel title = new JLabel();
    TermsForGame terms = new TermsForGame();

    public Ventana() {

        while (digitOnly) {
            try {

                terms.setLaunchings(Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Digite cuantos lanzamientos se haran por jugadores")));
                digitOnly = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros");
            }
        }

        digitOnly = true;
        while (digitOnly) {
            try {
                terms.setDoubleForFail(Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Digite el doble que hara que un jugador pierda \n(si es doble uno escribri 1, si es doble dos escribir 2 etc)")));
                if (Integer.toString(terms.getLaunchings()).replace("0", "").length() > 1) {
                    Thread.sleep(100);
                } else {
                    digitOnly = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Solo debe ingresar un numero");
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
                for (int i = 0; i < terms.getLaunchings(); i++) {
                    Launching launching = new Launching(i);
                    launching.setIsDoubleForFail(terms);
                    player.setLaunching(launching);
                }
                player.calculateAlldata(terms);
                saveResult(player);

                Ventana2 ventana2 = new Ventana2(player, terms);
                ventana2.setVisible(true);
                ventana2.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent evt) {
                        setIdJugador(player.getId());
                        setTitleButton1("Jugador #" + (player.getId() + 1));
                        boton1.setEnabled(false);
                        boton1.setEnabled(true);
                        if (player.getId() > 1) {
                            setStatusFinish(true);
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

        String winner = result.getWinner() == 0 ? "\nNadie gano porque todos sacaron doble 1"
                : "\nGanador:  Jugador #" + result.getWinner();
        JOptionPane.showMessageDialog(null,
                "\nParticipante con mas Dobles: Jugador #" + result.getPlayerWithMostEqualDouble()
                        + "\nParticipante con mas parejas repetidas: Jugador #"
                        + result.getPlayerWithMostRepeatedLaunchings() + "\nCantidad de jugadores que perdieron: "
                        + result.getLosersAmount() + winner + "\nPerdedor:  Jugador #" + result.getLoser()

        );
        // System.out.println("\nParticipante con mas Dobles: Jugador #" +
        // result.getPlayerWithMostEqualDouble());
        // System.out.println(
        // "Participante con mas parejas repetidas: Jugador #" +
        // result.getPlayerWithMostRepeatedLaunchings());
        // System.out.println("Cantidad de jugadores que perdieron: " +
        // result.getLosersAmount());
        // System.out.println(result.getWinner() == 0 ? "Nadie gano porque todos sacaron
        // doble 1"
        // : "Ganador: Jugador #" + result.getWinner());
        // System.out.println("Perdedor: Jugador #" + result.getLoser());
        this.result.dispose();
        this.setTitleButton1("Jugador #1");
        this.setStatusFinish(false);
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

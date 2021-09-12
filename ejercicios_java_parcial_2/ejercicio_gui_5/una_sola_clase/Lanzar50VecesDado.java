package ejercicios_java_parcial_2.ejercicio_gui_5.una_sola_clase;


import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.plaf.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Lanzar50VecesDado {
    static Ventana v = new Ventana();

    public static void main(String[] args) {

        v.setVisible(true);
    }
}

class Ventana extends JFrame {
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



// inicio ventana 2

class Ventana2 extends JFrame {
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ventana2(Player player) {
        setSize((int) (width / 2), 500);
        setTitle("Jugador #" + player.getId());

        JPanel panelP = new JPanel();
        JScrollPane panelScroll = new JScrollPane();

        panelP.setLayout(null);
        panelP.setBackground(Color.white);

        int index = 0;
        for (Launching Launching : player.getLaunchings()) {
            index++;
            if (Launching.getId() == 0) {
                JpanelLaunching launching = new JpanelLaunching(20, 10, (int) (width / 4.5) - 20, (int) (height * 0.14),
                        Launching);
                panelP.add(launching);
            } else {
                JpanelLaunching launching = new JpanelLaunching(20, (10 + (int) (height * 0.14)) * Launching.getId(),
                        (int) (width / 4.5) - 20, (int) (height * 0.14), Launching);
                panelP.add(launching);
            }
        }

        DividerPrincipal divider = new DividerPrincipal(width / 2, 10,
                (10 + (int) (height * 0.14)) * player.getLaunchings().size() - 1, 1);
        panelP.add(divider);

        if ((30 + (int) (height * 0.14)) * player.getLaunchings().size() - 1 < height) {
            if (player.getLaunchings().size() > 5) {
                setSize(width / 2, (10 + (int) (height * 0.14)) * player.getLaunchings().size() - 1);
                panelScroll.setBounds(10, 10, width / 2,
                        (5 + (int) (height * 0.14)) * player.getLaunchings().size() - 1);
            } else {
                setSize(width / 2, (int) (height * 0.85));
                panelScroll.setBounds(10, 10, width / 2, (int) (height * 0.80));
            }

        } else {
            setSize(width / 2, (int) (height * 0.9));
            panelScroll.setBounds(10, 10, width / 2, (int) (height * 0.9));
        }

        int boundYDefault = 10;
        for (int i = 0; i < 6; i++) {
            if (i != 0)
                boundYDefault += 50;
            int value = player.getTotalNumbersForPlayer().getListNumbers().get(i + 1);
            panelP.add(panel((width / 4) + 10, boundYDefault, 50, 50,
                    "ejercicios_java_parcial_2/ejercicio_3/assets/cara-" + (i + 1) + "-removebg-preview.png"));

            panelP.add(panel2((width / 4) + 10 + 50, boundYDefault, 200, 50, "",
                    " " + value + (value > 1 ? " veces" : " vez"), false));
        }

        JButton boton = new JButton("Mas detalles");
        boton.setBounds((width / 4) + 10, (int) (width * 0.25), (int) (width * 0.088), 30);

        JLabel status = new JLabel(player.isLoser() ? "Perdio La Partida" : "Gano La Partida ");
        ColorUIResource colorTrue = new ColorUIResource(7, 147, 0);
        ColorUIResource colorFalse = new ColorUIResource(211, 11, 6);
        status.setForeground(player.isLoser() ? colorFalse : colorTrue);
        status.setBounds((width / 4) + 10, (int) (width * 0.27) + 20, (int) (width * 0.088), 30);

        final String ms;
        NumbersForPlayer numbers = player.getTotalNumbersForPlayer();
        // System.out.println("total de numeros: " + numbers.getTotalNumbers());
        if (!player.isLoser()) {
            ms = "RESULTADOS: \nTotal de dobles obtenidos: " + player.getRepeatedEqualDouble()
                    + "\nTotal de numeros pares: " + numbers.getTotalEvenNumber() + "\nTotal de numeros impares: "
                    + numbers.getTotalOddNumbers() + "\nEl numero que mas salió: " + numbers.getNumberHigher()
                    + "\nEl numero que menos salió: " + numbers.getSmallestNumber() + "\nEl promedio de salidas: "
                    + numbers.getAverage() + "\nparejas de numeros repetidas: " + player.getRepeatedLaunching();
        } else {
            ms = "RESULTADOS: \nTotal de dobles obtenidos: " + player.getRepeatedEqualDouble()
                    + "\nTotal de numeros pares: " + numbers.getTotalEvenNumber() + "\nTotal de numeros impares: "
                    + numbers.getTotalOddNumbers() + "\nEl numero que mas salió: " + numbers.getSmallestNumber()
                    + "\nEl numero que menos salió: " + numbers.getNumberHigher() + "\nEl promedio de salidas: "
                    + numbers.getAverage() + "\nparejas de numeros repetidas: " + player.getRepeatedLaunching()
                    + "\nparejas de numeros repetidas: " + player.getRepeatedLaunching()
                    + "\nPerdio la partida en el intento#: " + player.getIndexForFail();
        }

        boton.addActionListener(new ActionListener() {
            String message = ms;

            @Override
            public void actionPerformed(ActionEvent evento) {
                JOptionPane.showMessageDialog(null, message);
            }

        });

        panelP.add(boton);
        panelP.add(status);

        panelScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panelP.setPreferredSize(
                new DimensionUIResource(width / 2, (10 + (int) (height * 0.14)) * player.getLaunchings().size() - 1));
        panelScroll.setViewportView(panelP);
        add(panelScroll);
    }

    JPanel panel(int x, int y, int widths, int heights, String ruta) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(x, y, widths, heights);
        panel.setLayout(new GridLayout(1, 1));

        Image img = new ImageIcon(ruta).getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(widths, heights, Image.SCALE_SMOOTH));
        JLabel picLabel = new JLabel(img2);

        panel.add(picLabel);

        return panel;
    }

    JPanel panel2(int x, int y, int widths, int heights, String lanzamiento, String txt, boolean lanz) {

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBounds(x, y, widths, heights);
        panel.setLayout(null);
        panel.setLayout(new GridLayout(1, 1));

        JLabel text = new JLabel();

        text.setText(txt);

        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("bahnschrift", 0, 20));

        panel.add(text);

        return panel;
    }

}

/**
 * Launching
 */
class JpanelLaunching extends JPanel {

    public JpanelLaunching(int x, int y, int w, int h, Launching launching) {
        setBounds(x, y, w, h);
        setLayout(null);
        setBackground(Color.white);
        JPanel panelText = new JPanel();

        panelText.setBounds(0, 0, w, (int) (h / 2.6));
        panelText.setBackground(Color.white);
        panelText.setLayout(new GridLayout(1, 1));

        // JLabel text = new JLabel("Lanzamiento #" + (index + 1) + " =" + (random1 +
        // random2));
        JLabel text = new JLabel("Lanzamiento #" + (launching.getId() + 1) + " ="
                + (launching.getDice1().getValue() + launching.getDice2().getValue()));

        ColorUIResource colorFalse = new ColorUIResource(211, 11, 6);

        if (launching.isDoubleOne()) {

            text.setForeground(colorFalse);
        }

        text.setHorizontalAlignment(SwingConstants.LEFT);
        text.setVerticalAlignment(SwingConstants.BOTTOM);
        text.setFont(new Font("book antiqua", 0, 20));
        panelText.add(text);

        int widthDefault = (int) (w / 4.2);
        int heightDefault = h - (int) (h / 2.6);

        JPanel panelImage1 = new JPanel();
        panelImage1.setBounds(0, (int) (h / 2.8), widthDefault, heightDefault);
        panelImage1.setBackground(Color.white);

        Image img = new ImageIcon(!launching.isDoubleOne() ? launching.getDice1().getRelativePath()
                : "ejercicios_java_parcial_2/ejercicio_gui_5/assets/1MataTodo.png").getImage();

        ImageIcon img2 = new ImageIcon(img.getScaledInstance(widthDefault - 5, heightDefault - 5, Image.SCALE_SMOOTH));
        JLabel picLabel = new JLabel(img2);
        panelImage1.add(picLabel);

        JPanel panelImage2 = new JPanel();
        panelImage2.setBounds(widthDefault + 30, (int) (h / 2.8), widthDefault, heightDefault);
        panelImage2.setBackground(Color.white);

        Image imge2 = new ImageIcon(!launching.isDoubleOne() ? launching.getDice2().getRelativePath()
                : "ejercicios_java_parcial_2/ejercicio_gui_5/assets/1MataTodo.png").getImage();
        ImageIcon imge3 = new ImageIcon(
                imge2.getScaledInstance(widthDefault - 5, heightDefault - 5, Image.SCALE_SMOOTH));
        JLabel picLabel2 = new JLabel(imge3);
        panelImage2.add(picLabel2);

        add(panelImage2);
        add(panelImage1);
        add(panelText);
    }

}

/**
 * DividerPrincipal
 */
class DividerPrincipal extends JPanel {
    public DividerPrincipal(int width, int boundY, int heightSize, int widthSize) {
        this.setBounds((int) (width / 2), boundY, widthSize, heightSize);
        this.setBackground(Color.gray);
        this.setLayout(null);
    }
}



//inicio clase dado

class Dice {
    private int value;
    private String relativePath;

    public Dice() {
        RollDice();
    }

    void RollDice() {
        this.value = (int) (Math.random() * 6 + 1);
        this.relativePath = "ejercicios_java_parcial_2/ejercicio_gui_5/assets/cara-" + value + "-removebg-preview.png";
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public int getValue() {
        return value;
    }

}


//inicio clase lanzamiento
class Launching {
    private Dice dice1;
    private Dice dice2;
    private int id;

    public Launching(int id) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        this.dice1 = dice1;
        this.dice2 = dice2;

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Dice getDice1() {
        return dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    public Boolean isDoubleOne() {
        return (dice1.getValue() == 1 && dice2.getValue() == 1);
    }

    Map<Integer, Dice> getFormattedValues() {
        Map<Integer, Dice> mapAux = new HashMap<Integer, Dice>();
        if (this.getDice1().getValue() > this.getDice2().getValue()) {
            mapAux.put(1, this.getDice1());
            mapAux.put(2, this.getDice2());
        }

        if (this.getDice2().getValue() > this.getDice1().getValue()) {
            mapAux.put(1, this.getDice2());
            mapAux.put(2, this.getDice1());
        }

        if (this.getDice1().getValue() == this.getDice2().getValue()) {
            mapAux.put(1, this.getDice1());
            mapAux.put(2, this.getDice2());
        }

        return mapAux;
    }

    boolean equals(Dice dice1, Dice dice2) {

        return (dice1.getValue() == this.getDice1().getValue() && dice2.getValue() == this.getDice2().getValue())
                || (dice1.getValue() == this.getDice2().getValue() && dice2.getValue() == this.getDice1().getValue());
    }

}


//inicio clase player
class Player {
    private ArrayList<Launching> launchings = new ArrayList<Launching>();
    private int repeatedLaunching, repeatedEqualDouble;
    private Boolean fail = false;
    private int numbersForFail, indexForFail;
    private NumbersForPlayer totalNumbersForPlayer;
    private int id;

    public Player(int id) {
        this.id = id;

    }

    public void setLaunching(Launching launching) {
        this.launchings.add(launching);
    }

    public int getId() {
        return id;
    }

    public ArrayList<Launching> getLaunchings() {
        return this.launchings;
    }

    public int getRepeatedLaunching() {
        return repeatedLaunching / 2;
    }

    public int getRepeatedEqualDouble() {
        return repeatedEqualDouble;
    }

    public Boolean isLoser() {
        return fail;
    }

    public int getIndexForFail() {
        return indexForFail;
    }

    public NumbersForPlayer getTotalNumbersForPlayer() {
        return totalNumbersForPlayer;
    }

    public void setDoublesAndRepeatedLaunchings() {
        int localTotalRepeatedLaunchings = 0;
        Map<String, Integer> simpleList = new HashMap<String, Integer>();
        ArrayList<Boolean> simpleList2 = new ArrayList<Boolean>();

        String name1Aux = "", name2Aux = "";
        for (Launching launching : this.launchings) {

            int doubles = 0;
            for (int i = 0; i < launchings.size(); i++) {
                Launching launching2 = launchings.get(i);
                name1Aux = Integer.toString(launching.getFormattedValues().get(1).getValue());
                name2Aux = Integer.toString(launching.getFormattedValues().get(2).getValue());

                if (launching.equals(launching2.getDice1(), launching2.getDice2())) {
                    doubles++;
                    if (doubles >= 2) {
                        simpleList.put(name1Aux + name2Aux, 2);
                        i = launchings.size();
                    }
                } else {
                    simpleList.put(name1Aux + name2Aux, 1);
                }
            }

            if (launching.getDice1().getValue() == launching.getDice2().getValue()) {
                this.repeatedEqualDouble++;
            }

            if (launching.isDoubleOne()) {
                this.numbersForFail += 1;
            }
            if (this.numbersForFail >= 3 && !this.fail) {
                this.fail = true;
                this.indexForFail = launching.getId() + 1;
            }

        }

        for (Integer number : simpleList.values()) {
            if (number >= 2) {
                localTotalRepeatedLaunchings += number;
            }
        }

        this.repeatedLaunching = localTotalRepeatedLaunchings;

    }

    public void setTotalNumbersForPlayer() {
        NumbersForPlayer totalNumbersForPlayer = new NumbersForPlayer();
        for (Launching launching : this.launchings) {
            totalNumbersForPlayer.fillAllData(launching.getDice1().getValue());
            totalNumbersForPlayer.fillAllData(launching.getDice2().getValue());
            totalNumbersForPlayer.setListNumbers();
            totalNumbersForPlayer.setTotalNumbers(launching.getDice1().getValue());
            totalNumbersForPlayer.setTotalNumbers(launching.getDice2().getValue());
            totalNumbersForPlayer.setAverage();

            totalNumbersForPlayer.higherNumber();
        }

        totalNumbersForPlayer.calculateFinalSmallestNumber();
        this.totalNumbersForPlayer = totalNumbersForPlayer;
    }

    public void calculateAlldata() {
        setDoublesAndRepeatedLaunchings();
        setTotalNumbersForPlayer();
    }

}



//inicio clase numeros del jugador

class NumbersForPlayer {
    private int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, totalEvenNumber = 0, totalOddNumbers = 0,
            totalNumbers = 0, numberHigher, smallestNumber;
    private double average;
    private Map<Integer, Integer> listNumbers = new HashMap<Integer, Integer>();

    public NumbersForPlayer() {

    }

    public int getTotalNumbers() {
        return totalNumbers;
    }

    public void setTotalNumbers(int dato) {
        this.totalNumbers += dato;
    }

    public Map<Integer, Integer> getListNumbers() {
        return listNumbers;
    }

    public int getNumberHigher() {
        return numberHigher;
    }

    public int getSmallestNumber() {
        return smallestNumber;
    }

    public int getTotalEvenNumber() {
        return totalEvenNumber;
    }

    public int getTotalOddNumbers() {
        return totalOddNumbers;
    }

    public double getAverage() {
        return average;
    }

    public void setOneOddNumbers() {
        this.totalOddNumbers++;
    }

    public void setOneEvenNumber() {
        this.totalEvenNumber++;
    }

    public void setOne() {
        this.one++;
    }

    public int getOne() {
        return one;
    }

    public void setTwo() {
        this.two++;
    }

    public int getTwo() {
        return two;
    }

    public void setThree() {
        this.three++;
    }

    public int getThree() {
        return three;
    }

    public void setFour() {
        this.four++;
    }

    public int getFour() {
        return four;
    }

    public void setFive() {
        this.five++;
    }

    public int getFive() {
        return five;
    }

    public void setSix() {
        this.six++;
    }

    public int getSix() {
        return six;
    }

    public void setAverage() {
        this.average = this.getTotalNumbers() / 50;
    }

    public void higherNumber() {
        if (this.one >= this.two && this.one >= this.three && this.one >= this.four && this.one >= this.five
                && this.one >= this.six)
            numberHigher = 1;

        else if (this.two >= this.one && this.two >= this.three && this.two >= this.four && this.two >= this.five
                && this.two >= this.six)
            numberHigher = 2;

        else if (this.three >= this.one && this.three >= this.two && this.three >= this.four && this.three >= this.five
                && this.three >= this.six)
            numberHigher = 3;

        else if (this.four >= this.one && this.four >= this.two && this.four >= this.three && this.four >= this.five
                && this.four >= this.six)
            numberHigher = 4;

        else if (this.five >= this.one && this.five >= this.two && this.five >= this.three && this.five >= this.four
                && this.five >= this.six)
            numberHigher = 5;

        else if (this.six >= this.one && this.six >= this.two && this.six >= this.three && this.six >= this.four
                && this.six >= this.five)
            ;
    }

    void calculateFinalSmallestNumber() {
        this.smallestNumber(this.one, 1);
        this.smallestNumber(this.two, 2);
        this.smallestNumber(this.three, 3);
        this.smallestNumber(this.four, 4);
        this.smallestNumber(this.five, 5);
        this.smallestNumber(this.six, 6);
    }

    public void smallestNumber(int dato, int number) {
        int valMenor = 0;

        // System.out.println("\n\n\nInicio de la vuelta");

        // System.out.println("\ndato: " + dato);
        if (dato <= this.one) {
            valMenor++;
            // System.out.println("\n||uno true ||\n");
            // System.out.println("uno: " + this.one);
        }

        if (dato <= this.two) {
            valMenor++;
            // System.out.println("\n||dos true ||\n");
            // System.out.println("dos: " + this.two);
        }

        if (dato <= this.three) {
            valMenor++;
            // System.out.println("\n||tres true ||\n");
            // System.out.println("tres: " + this.three);
        }

        if (dato <= this.four) {
            valMenor++;
            // System.out.println("\n||cuatro true ||\n");
            // System.out.println("cuatro: " + this.four);
        }

        if (dato <= this.five) {
            valMenor++;
            // System.out.println("\n||cinco true ||\n");
            // System.out.println("cinco: " + this.five + "||");
        }

        if (dato <= this.six) {
            valMenor++;
            // System.out.println("\n||seis true ||\n");
            // System.out.println("seis: " + this.six + "||");
        }
        // System.out.println("\nvalMenor: " + valMenor);
        // System.out.println("\nfin de la vuelta\n\n\n");
        if (valMenor == 6) {

            this.smallestNumber = number;
        }

    }

    public void setListNumbers() {
        this.listNumbers.put(1, one);
        this.listNumbers.put(2, two);
        this.listNumbers.put(3, three);
        this.listNumbers.put(4, four);
        this.listNumbers.put(5, five);
        this.listNumbers.put(6, six);
    }

    void fillAllData(int dato) {
        switch (dato) {
            case 1:
                this.setOne();
                this.setOneOddNumbers();
                break;
            case 2:
                this.setTwo();
                this.setOneEvenNumber();
                break;
            case 3:
                this.setThree();
                this.setOneOddNumbers();
                break;
            case 4:
                this.setFour();
                this.setOneEvenNumber();
                break;
            case 5:
                this.setFive();
                this.setOneOddNumbers();
                break;

            default:
                this.setSix();
                this.setOneEvenNumber();
                break;
        }
    }
}



//inicio clase resultado

class Result {
    private ArrayList<Player> players = new ArrayList<Player>();
    private int playerWithMostEqualDouble;
    private int playerWithMostRepeatedLaunchings;
    private int losersAmount;
    private int winner;
    private int loser;

    public Result() {
    };

    public void setPlayers(Player player) {
        this.players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayerWithMostEqualDouble(int playerWithMostEqualDouble) {
        this.playerWithMostEqualDouble = playerWithMostEqualDouble;
    }

    public int getPlayerWithMostEqualDouble() {
        return playerWithMostEqualDouble;
    }

    public void setPlayerWithMostRepeatedLaunchings(int playerWithMostRepeatedLaunchings) {
        this.playerWithMostRepeatedLaunchings = playerWithMostRepeatedLaunchings;
    }

    public int getPlayerWithMostRepeatedLaunchings() {
        return playerWithMostRepeatedLaunchings;
    }

    public void setLosersAmount(int losersAmount) {
        this.losersAmount = losersAmount;
    }

    public int getLosersAmount() {
        return losersAmount;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getWinner() {
        return winner;
    }

    public void setLoser(int loser) {
        this.loser = loser;
    }

    public int getLoser() {
        return loser;
    }

    void calculatePlayerWithMostEqualDouble() {
        int defaultMaximun = 0;
        int idPlayerAux = 0;
        for (Player player : players) {
            // System.out.println("\n\nPlayer #" + player.getId());
            // System.out.println("dobles de jugador: " + player.getRepeatedEqualDouble());
            // System.out.println("parejas repetida de jugador: " + player.getRepeatedLaunching());
            if (player.getId() == 1) {
                defaultMaximun = player.getRepeatedEqualDouble();
                idPlayerAux = player.getId();
            } else {
                if (player.getRepeatedEqualDouble() > defaultMaximun) {
                    defaultMaximun = player.getRepeatedEqualDouble();
                    idPlayerAux = player.getId();
                }
            }
        }
        this.setPlayerWithMostEqualDouble(idPlayerAux);
    }

    void calculatePlayerWithMostRepeatedLaunchings() {
        int defaultMaximun = 0;
        int idPlayerAux = 0;

        for (Player player : players) {
            if (player.getId() == 0) {
                defaultMaximun = player.getRepeatedLaunching();
                idPlayerAux = player.getId();
            } else {
                if (player.getRepeatedLaunching() > defaultMaximun) {
                    defaultMaximun = player.getRepeatedLaunching();
                    idPlayerAux = player.getId();
                }
            }
        }
        this.setPlayerWithMostRepeatedLaunchings(idPlayerAux);
    }

    void calculateTotalLoserAmount() {
        int totalAux = 0;
        for (Player player : players) {
            if (player.isLoser()) {
                totalAux++;
            }
        }
        this.setLosersAmount(totalAux);
    }

    void calculateWinner() {
        int defaultMaximun = 0;
        int idPlayerAux = 0;
        ArrayList<Player> playerAux = new ArrayList<Player>();
        int totalAux = 0;

        // System.out.println("\n\nWinners ");
        if (this.getLosersAmount() == (players.size())) {
            this.setWinner(0);
        } else {
            for (Player player : players) {
                if (!player.isLoser()) {
                    playerAux.add(player);
                }
            }

            for (Player player : playerAux) {

            //     System.out.println("\nplayer # " + player.getId());
                
            // System.out.println("Total numbers: "+player.getTotalNumbersForPlayer().getTotalNumbers() );
                if (player.getId() == 1) {
                    defaultMaximun = player.getTotalNumbersForPlayer().getTotalNumbers();
                    idPlayerAux = player.getId();
                } else {
                    if (player.getTotalNumbersForPlayer().getTotalNumbers() > defaultMaximun) {
                        defaultMaximun = player.getTotalNumbersForPlayer().getTotalNumbers();
                        idPlayerAux = player.getId();
                    }
                }

            }
            this.setWinner(idPlayerAux);
        }
    }

    void calculateLoser() {
        int defaultMinimun = 0;
        int idPlayerAux = 0;

        // System.out.println("\n\nWinners ");
        for (Player player : players) {

            // System.out.println("\nplayer # " + player.getId());
            // System.out.println("Total numbers: "+player.getTotalNumbersForPlayer().getTotalNumbers() );
            if (player.getId() == 1) {
                // System.out.print("Es el primero");
                defaultMinimun = player.getTotalNumbersForPlayer().getTotalNumbers();
                idPlayerAux = player.getId();
            } else {
                if (player.getTotalNumbersForPlayer().getTotalNumbers() < defaultMinimun) {
                    // System.out.print("es menor que el anterior");
                    defaultMinimun = player.getTotalNumbersForPlayer().getTotalNumbers();
                    idPlayerAux = player.getId();

                }
            }
        }
        this.setLoser(idPlayerAux);
    }

    public void calculateAllData() {
        this.calculatePlayerWithMostEqualDouble();
        this.calculatePlayerWithMostRepeatedLaunchings();
        this.calculateTotalLoserAmount();
        this.calculateWinner();
        this.calculateLoser();
    }
}



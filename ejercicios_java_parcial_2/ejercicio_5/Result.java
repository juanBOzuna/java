package ejercicios_java_parcial_2.ejercicio_5;

import java.util.ArrayList;

public class Result {
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

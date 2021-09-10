package ejercicio_5;

import java.util.ArrayList;

public class Result {
    ArrayList<Player> players = new ArrayList<Player>();
    int playerWithMostEqualDouble;
    int playerWithMostRepeatedLaunchings;
    int losersAmount;
    Player winner;
    Player loser;

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

    public void calculatePlayerWithMostEqualDouble() {
        int defaultMaximun = 0;
        int idPlayerAux = 0;
        for (Player player : players) {
            System.out.println("Player #" + player.getId());
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
        this.setPlayerWithMostEqualDouble(idPlayerAux + 1);
    }

    public void calculatePlayerWithMostRepeatedLaunchings() {
        int defaultMaximun = 0;
        int idPlayerAux = 0;

        for (Player player : players) {
            if (player.getId() == 0) {
                defaultMaximun = player.getRepeatedLaunching();
                idPlayerAux = player.getId();
            } else {
                if (player.getRepeatedLaunching() < defaultMaximun) {
                    defaultMaximun = player.getRepeatedLaunching();
                    idPlayerAux = player.getId();
                }
            }
        }
        this.setPlayerWithMostRepeatedLaunchings(idPlayerAux + 1);
    }

    public void calculateAllData() {
        this.calculatePlayerWithMostEqualDouble();
        this.calculatePlayerWithMostRepeatedLaunchings();
    }
}

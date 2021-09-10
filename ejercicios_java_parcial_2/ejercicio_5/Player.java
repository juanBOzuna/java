package ejercicio_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    ArrayList<Launching> launchings = new ArrayList<Launching>();
    int repeatedLaunching, repeatedEqualDouble;
    Boolean fail = false;
    int numbersForFail, indexForFail;
    NumbersForPlayer totalNumbersForPlayer;
    int id;

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

    public Boolean getFail() {
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

        // Map<Integer, Integer> simpleListAux1 = new HashMap<Integer, Integer>();
        for (Launching launching : this.launchings) {

            int doubles = 0;
            for (int i = 0; i < launchings.size(); i++) {
                Launching launching2 = launchings.get(i);

                if (launching.equals(launching2.getDice1(), launching2.getDice2())) {
                    doubles++;
                    if (doubles >= 2) {
                        simpleList.put(Integer.toString(launching.getFormattedValues().get(1).getValue())
                                + Integer.toString(launching.getFormattedValues().get(2).getValue()), 2);
                        i = launchings.size();
                    }

                } else {
                    simpleList.put(Integer.toString(launching.getFormattedValues().get(1).getValue())
                            + Integer.toString(launching.getFormattedValues().get(2).getValue()), 1);
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
            totalNumbersForPlayer.fillAllData(launching.dice1.getValue());
            totalNumbersForPlayer.fillAllData(launching.dice2.getValue());
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

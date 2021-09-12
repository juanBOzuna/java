package ejercicios_java_parcial_2.ejercicio_gui_5.refactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
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

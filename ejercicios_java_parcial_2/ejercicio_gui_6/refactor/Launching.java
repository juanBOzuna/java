package ejercicios_java_parcial_2.ejercicio_gui_6.refactor;

import java.util.HashMap;
import java.util.Map;

public class Launching {
    private Dice dice1;
    private Dice dice2;
    private int id;
    private boolean isDoubleForFail;

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

    // public Boolean isDoubleForFail(TermsForGame terms) {
    //     return (dice1.getValue() == terms.getDoubleForFail() && dice2.getValue() == terms.getDoubleForFail());
    // }

    public void setIsDoubleForFail(TermsForGame terms) {
        this.isDoubleForFail = (dice1.getValue() == terms.getDoubleForFail()
                && dice2.getValue() == terms.getDoubleForFail());
    }
    
    public Boolean getIsDoubleForFail(){
        return this.isDoubleForFail;
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
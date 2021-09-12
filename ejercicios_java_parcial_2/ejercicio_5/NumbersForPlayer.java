package ejercicios_java_parcial_2. ejercicio_5;

import java.lang.reflect.Array;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NumbersForPlayer {
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

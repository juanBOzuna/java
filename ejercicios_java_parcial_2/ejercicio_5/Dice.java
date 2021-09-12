package ejercicios_java_parcial_2. ejercicio_5;

public class Dice {
    private int value;
    private String relativePath;

    public Dice() {
        RollDice();
    }

    void RollDice() {
        this.value = (int) (Math.random() * 6 + 1);
        this.relativePath = "ejercicios_java_parcial_2/ejercicio_5/assets/cara-" + value + "-removebg-preview.png";
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

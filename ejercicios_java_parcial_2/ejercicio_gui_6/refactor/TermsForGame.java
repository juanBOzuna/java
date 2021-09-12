package ejercicios_java_parcial_2.ejercicio_gui_6.refactor;

public class TermsForGame {
    private int launchings;
    private int doubleForFail;

    public TermsForGame() {
    }

    public void setLaunchings(int launchings) {
        this.launchings = launchings;
    }

    public int getLaunchings() {
        return launchings;
    }

    public void setDoubleForFail(int doubleForFail) {
        this.doubleForFail = doubleForFail;
    }

    public int getDoubleForFail() {
        return doubleForFail;
    }

}

package ejercicios_adicionales;

import java.util.Scanner;

public class Kilometros_a_equivalentes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite cantidad de kilometros");

        double k = scan.nextDouble();

        double m = k * 1000;
        double cm = k * 100000;

        String message = "RESULTADOS: \nMETROS: " + m + " \nCENTIMETROS: " + cm;

        System.out.println(message);

    }
}

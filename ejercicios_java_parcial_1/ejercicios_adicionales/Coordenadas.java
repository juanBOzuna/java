package ejercicios_java_parcial_1. ejercicios_adicionales;

import java.util.Scanner;

public class Coordenadas {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite la coordenada x");

        double x = scan.nextDouble();

        System.out.println("Digite la coordenada y");
        double y = scan.nextDouble();

        String message = "";

        if (x > 0 && y > 0) {
            message = "la coordeada (" + x + "," + y + ") Se encuentra en el primer cuadrante";
        }

        if (x > 0 && y < 0) {
            message = "la coordeada (" + x + "," + y + ") Se encuentra en el segundo cuadrante";
        }

        if (x < 0 && y < 0) {
            message = "la coordeada (" + x + "," + y + ") Se encuentra en el tercer cuadrante";
        }

        if (x < 0 && y > 0) {
            message = "la coordeada (" + x + "," + y + ") Se encuentra en el cuarto cuadrante";
        }

        if (x == 0 && y == 0) {
            message = "la coordeada (" + x + "," + y + ") Se encuentra en el centro";
        }
        System.out.println(message);
    }

}

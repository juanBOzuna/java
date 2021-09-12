package ejercicios_java_parcial_1. ejercicio_por_consola_3;

import java.util.Scanner;

public class etapaDeVida {
    public static void main(String[] args) {

        System.out.print("\nDigite su edad ");
        Scanner scan = new Scanner(System.in);
        int edad = scan.nextInt();
        String etapa = "";

        if (edad <= 5) {
            etapa = "Primer Infante";
        }
        if (edad >= 6 && edad <= 11) {
            etapa = "Infante";

        }
        if (edad >= 12 && edad < 14) {
            etapa = "Adolescente";

        }
        if (edad >= 14 && edad < 18) {
            etapa = "Adolescente Joven";

        }
        if (edad >= 18 && edad <= 26) {
            etapa = "Adulto Joven";

        }
        if (edad > 26 && edad < 59) {
            etapa = "Adulto";

        }
        if (edad >= 27 && edad <= 59) {
            etapa = "Adulto Maduro";

        }
        if (edad >= 60) {
            etapa = "Adulto Mayor";

        }

        System.out.print("\nUsted es un" + etapa);

    }
}

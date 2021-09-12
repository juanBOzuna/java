package ejercicios_java_parcial_1.ejercicios_adicionales;

import java.util.Scanner;

public class CantidadDeVocales {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite una cadena de texto");

        String palabra = scan.next();

        int vocales = 0;

        for (int x = 0; x < palabra.length(); x++) {
            if ((palabra.charAt(x) == 'a') || (palabra.charAt(x) == 'e') || (palabra.charAt(x) == 'i')
                    || (palabra.charAt(x) == 'o') || (palabra.charAt(x) == 'u')) {
                vocales++;
            }
        }

        System.out.println("La cadena de texto " + palabra + " tiene " + vocales + " vocales");
    }
}

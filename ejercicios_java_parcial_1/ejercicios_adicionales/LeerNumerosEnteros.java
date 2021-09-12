package ejercicios_java_parcial_1. ejercicios_adicionales;

import java.util.Scanner;

public class LeerNumerosEnteros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite el primer numero entero");

        int num1 = scan.nextInt();

        System.out.println("Digite el segundo numero entero");
        int num2 = scan.nextInt();

        String message = "SUMA: " + num1 + "+" + num2 + " = " + (num1 + num2);

        System.out.println(message);

    }
}

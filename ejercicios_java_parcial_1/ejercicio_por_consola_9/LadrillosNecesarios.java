package ejercicio_por_consola_9;

import java.util.Scanner;

public class LadrillosNecesarios {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite el precio de un block ");
        double precio = scan.nextDouble();

        System.out.println("\nPara construir una casa con 4 paredes de 7 metros cuadrados cada uno se necesitan "
                + (4 * 7) * 13 + " blocks.");

        System.out.println("El precio total de " + (4 * 7) * 13 + " blocks es: $" + ((4 * 7) * 13) * precio);
    }
}

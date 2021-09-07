package ejercicios_adicionales;

import java.util.Scanner;

public class PromedioYDesviacion {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int datos[] = new int[10];
        int numero = 0, sumaTotal = 0;
        double sumaDiferencia = 0, promedio = 0;
        int index = 0;

        for (int i = 0; i < 10; i++) {

            System.out.println("Digite el entero #" + (i + 1));
            numero = scan.nextInt();
            datos[i] = numero;
        }

        for (int i : datos) {
            sumaTotal += i;
        }

        promedio = sumaTotal / 10;

        for (int i : datos) {
            index++;
            sumaDiferencia += Math.pow((i - promedio), 2);
            System.out.println("\nEntero # " + index + ": " + i);
        }

        double desviacion = Math.sqrt(sumaDiferencia / 10);

        System.out.println("\nPromedio de los numeros: " + promedio);
        System.out.println("\nDesviacion estandar de los numeros: " + desviacion);
    }
}

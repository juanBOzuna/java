package ejercicio_por_consola_10;

import java.util.Scanner;

public class TiempoDeRecorrido {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite la distancia en pies: ");

        double destino = scan.nextDouble();
        double pies = destino / 6561.68;

        System.out.println("para llegar a " + destino + " pies de distancia se demora " + pies + " minutos");
    }
}

package ejercicios_adicionales;

import java.util.Scanner;

public class DistanciaEntreDosPuntos {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("digite el primer termino del punto #1");
        double x1 = scan.nextDouble();

        System.out.println("digite el segundo termino del punto #1");
        double y1 = scan.nextDouble();

        System.out.println("digite el primer termino del punto #2");
        double x2 = scan.nextDouble();

        System.out.println("digite el segundo termino del punto #2");
        double y2 = scan.nextDouble();

        System.out.println("Distancia: " + Math.sqrt((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))));
    }
}

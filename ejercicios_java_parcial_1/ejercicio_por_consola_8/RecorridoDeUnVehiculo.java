package ejercicios_java_parcial_1. ejercicio_por_consola_8;

import java.util.Scanner;

public class RecorridoDeUnVehiculo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("ingrese los kilometros recorridos: ");
        double recorrido = scan.nextDouble();
        System.out.println("ingrese el valor de un litro de combustible: ");
        double costoLitro = scan.nextDouble();

        double galones = (recorrido * 0.1498) * 0.264172; // sacamos los litros que gasto en total y convertimos a galon
        double costoTotal = costoLitro * (recorrido * 0.1498);// multiplicamos el valor del litro por los litros totales
        double yardas = recorrido * 1093.61; // convertimos de kilometros a yardas
        double costoYarda = (0.00013697712 * yardas) * costoLitro;// sacamos el valor de
        double tanqueadas = (recorrido * 0.1498) / 75.7082;

        System.out.println("---------------------");
        System.out.println("resultados obtenidos: " + "\n");
        System.out.println("\nNumero de galones necesarios: " + galones);
        System.out.println("\nCosto del combustible por " + recorrido + "km recorridos: " + costoTotal);
        System.out.println("\nCosto total de cada yarda recorrida: " + costoYarda);
        System.out.println("\nNumero de tanqueadas full que debe hacer: " + tanqueadas);
        System.out.println("\nDebe tanquear full cada 1658120.71388 pies" + "\n");
        System.out.println("---------------------" + "\n");
    }
}

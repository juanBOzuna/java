package ejercicios_java_parcial_1. ejercicios_adicionales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LeerNumerosImprimirMayor {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListInt = new ArrayList<Integer>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite el primer numero");
        int x1 = scan.nextInt();
        arrayListInt.add(x1);
        System.out.println("Digite el segundo numero");
        int x2 = scan.nextInt();
        arrayListInt.add(x2);
        System.out.println("Digite el tercer numero");
        int x3 = scan.nextInt();
        arrayListInt.add(x3);

        Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(arrayListInt, comparador);

        System.out.println("\nEl numero mas grande es: " + arrayListInt.get(0));
    }
}

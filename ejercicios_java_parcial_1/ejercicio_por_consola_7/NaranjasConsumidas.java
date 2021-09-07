package ejercicio_por_consola_7;

import java.util.Scanner;

public class NaranjasConsumidas {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("cuantos kilovoltios requiere su iluminacion? ");
        double kv = scan.nextDouble();

        double nrjs = kv / 0.05;
        double toneladas = ((nrjs * 6) * 0.001) * 0.001;

        System.out.println( "su iluminacion requiere de " + nrjs + " naranjas para funcionar \n" );
        System.out.println( "Es decir " + toneladas + " toneladas de naranjas" +"\n");

    }
}

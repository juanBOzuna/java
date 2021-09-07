package ejercicio_por_consola_6;

import java.util.Scanner;

public class ValorOro {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite la cantidad de kilogramos ");
        double kg = scan.nextDouble();

        System.out.println("Digite el valor actual de la onza ");
        double valoronza = scan.nextDouble();


        double onza = kg * 35.274;
        System.out.println(kg+" Kilos son: $" + onza * valoronza);
    }
}

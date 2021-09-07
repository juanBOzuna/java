package ejercicio_por_consola_4;

import java.util.Scanner;

public class Imc {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Digite su altura en metros ");
        double altura = scan.nextDouble();

        System.out.print("Digite su peso en kilogramos ");
        double peso = scan.nextDouble();
        double imc = 0;

        String ms = "", ms2 = "";

        if (altura <= 1 || peso <= 1) {
            ms = "los datos no pueden ser menores a 1";
        } else {
            imc = peso / (altura * altura);
            if (imc <= 18.5) {
                ms2 = "imc: " + imc;
                ms = "usted tiene delgadez, bajo peso o esta desnutrido";
            } else {
                if (imc > 18.5 && imc <= 24.9) {
                    ms2 = "imc: " + imc;
                    ms = "Usted esta normal";
                } else {
                    if (imc <= 25.0 && imc <= 29.9) {
                        ms2 = "imc: " + imc;
                        ms = "Usted tiene un peso superior al normal";
                    } else {
                        ms2 = "imc: " + imc;
                        ms = "Usted esta obeso";
                    }
                }
            }
        }

        System.out.println("\n" + ms);
        System.out.println(ms2);

    }
}

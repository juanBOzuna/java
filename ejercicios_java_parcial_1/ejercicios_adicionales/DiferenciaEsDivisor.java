package ejercicios_java_parcial_1. ejercicios_adicionales;

import java.util.Scanner;

public class DiferenciaEsDivisor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite un numero ");
        int num1 = 0;
        num1 = scan.nextInt();
        System.out.println("Digite otro numero ");
        int num2 = scan.nextInt();
        int residuo = num1 - num2;
        String message = "El residuo es " + residuo;

        System.out.println("num1-num2 =  " + residuo + "segundo divisor: " + (residuo % num2) + "primer divisor: "
                + (residuo % num1));

        if (residuo % num2 == 0) {
            message += " , es divisor del segundo numero digitado: " + num2;
        }

        if (residuo % num1 == 0) {
            message += " , es divisor del primer numero digitado: " + num1;
        }

        if (!message.contains("divisor")) {
            message += " y no es divisor de ninguno de los numeros digitados";
        }

        System.out.println(message);
    }
}

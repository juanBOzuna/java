package ejercicio_por_consola_3;

import java.util.Scanner;

public class etapaDeVida {
    public static void main(String[] args) {

        System.out.print("\nDigite su edad ");
        Scanner scan = new Scanner(System.in);
        int edad = scan.nextInt();

        switch (edad) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.print("\nUsted esta en primera Infancia");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                System.out.print("\nUsted esta en la nfancia");
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                System.out.print("\nUsted esta en la adolescencia");
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                System.out.print("\nUsted esta en la juventud");
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                System.out.print("\nusted es un adulto");
                break;
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
                System.out.print("\n usted es un adulto maduro");
                break;
            default:
                System.out.print("\nusted es un adulto mayor");

        }
    }
}

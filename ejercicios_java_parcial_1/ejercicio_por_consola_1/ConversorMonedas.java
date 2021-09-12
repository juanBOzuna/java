package ejercicios_java_parcial_1. ejercicio_por_consola_1;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Boolean validador = true;
        int origen = 0, destino = 0;
        double cantidad = 0, resultado;

        while (validador) {
            System.out.print("\nEscoja la moneda de origen (Peso= 1 , Dolar= 2 , Euro = 3) ");
            origen = scan.nextInt();
            if (origen >= 4 || origen == 0) {
                System.out.print("\nDebe ser un numero del 1 al 3");

            } else {
                validador = false;
            }
        }

        validador = true;
        while (validador) {
            System.out.print("Escoja la moneda de Salida (Peso= 1 , Dolar= 2 , Euro = 3) ");
            destino = scan.nextInt();
            if (origen >= 4 || origen == 0) {
                System.out.print("\nDebe ser un numero del 1 al 3");

            } else {
                validador = false;
            }
        }
        validador = true;

        while (validador) {

            switch (origen) {
                case 1:
                    System.out.print("Dijite la cantidad de Pesos colombianos ");
                    cantidad = scan.nextInt();
                    switch (destino) {
                        case 1:
                            validador = false;
                            System.out.print(
                                    "al convertir de peso a peso estas obteniendo el mismo valor:  $" + cantidad);
                            break;
                        case 2:

                            validador = false;
                            resultado = cantidad * 0.00026;
                            System.out.print("\n");
                            System.out.print("Resultado: $" + cantidad + " Pesos colombianos equivalen a " + resultado
                                    + " dolar");
                            break;
                        case 3:

                            validador = false;
                            resultado = cantidad * 0.0002272;
                            System.out.print("Resultado: $" + cantidad + " Pesos colombianos equivalen a " + resultado
                                    + " Euros");
                            break;
                        default:
                            System.out.print("Las opciones de origen y salida debian ser valores entre 1 , 2 y 3");
                            validador = true;
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Dijite la cantidad de Dolares ");
                    cantidad = scan.nextInt();
                    switch (destino) {
                        case 1:
                            validador = false;
                            resultado = cantidad * 3799.88;
                            System.out.print("Resultado: $" + cantidad + " Dolar equivalen a " + resultado
                                    + " Pesos colombianos");
                            break;
                        case 2:
                            validador = false;
                            System.out.print(
                                    "al convertir de peso a peso estas obteniendo el mismo valor:  $" + cantidad);
                            break;
                        case 3:
                            validador = false;
                            resultado = cantidad * 0.84;
                            System.out.print("Resultado: $" + cantidad + " Dolar equivalen a " + resultado + " Euro");
                            break;
                        default:
                            System.out.print("Las opciones de origen y salida debian ser valores entre 1 , 2 y 3");
                            validador = true;
                            break;
                    }
                    
                    break;
                case 3:
                    System.out.print("Dijite la cantidad de Euros ");
                    cantidad = scan.nextInt();
                    switch (destino) {
                        case 1:
                            resultado = cantidad * 4511.32;
                            validador = false;
                            System.out.print("Resultado: $" + cantidad + " Euros equivalen a " + resultado
                                    + " pesos colombianos");
                            break;
                        case 2:
                            resultado = cantidad * 1.19;
                            validador = false;
                            System.out.print("Resultado: $" + cantidad + " Euros equivalen a " + resultado + " dolar");
                            break;
                        case 3:
                            validador = false;
                            System.out.print(
                                    "al convertir de peso a peso estas obteniendo el mismo valor:  $" + cantidad);
                            break;
                        default:
                            validador = false;
                            System.out.print("Las opciones de origen y salida debian ser valores entre 1 , 2 y 3");
                            validador = true;
                            break;
                    }
                    
                    break;
                default:
                    System.out.print("Las opciones de origen y salida debian ser valores entre 1 , 2 y 3");
                    validador = true;
            }

        }

    }

}

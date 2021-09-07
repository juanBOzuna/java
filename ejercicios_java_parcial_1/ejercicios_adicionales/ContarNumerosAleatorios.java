package ejercicios_adicionales;

public class ContarNumerosAleatorios {
    public static void main(String[] args) {
        Boolean validador = true;
        int random = 0, siete = 0, dos = 0, veinte = 0, veintinueve = 0, once = 0, ocho = 0, diez = 0;

        while (validador) {
            random = (int) (Math.random() * 200 + 1);

            switch (random) {
                case 7:
                    siete++;
                    break;
                case 2:
                    dos++;
                    break;
                case 20:
                    veinte++;
                    break;
                case 29:
                    veintinueve++;
                    break;
                case 11:
                    once++;
                    break;
                case 8:
                    ocho++;
                    break;
                case 10:
                    diez++;
                    break;
            }

            System.out.print("\nNumero aleatorio: " + random);

            if (ocho >= 2 && diez >= 5) {
                validador = false;
            }
        }

        System.out.print("\nRESULTADOS: \nNumero 7: " + siete + " veces\n" + "Numero 2: " + dos + " veces\n" + "Numero 20: " + veinte
                + " veces\n" + "Numero 29: " + veintinueve + " veces\n" + "Numero 11: " + once + " veces\n" + "\nAdemas saco " + ocho
                + " veces el numero 8 y " + diez + " veces el numero 10"

        );
    }
}

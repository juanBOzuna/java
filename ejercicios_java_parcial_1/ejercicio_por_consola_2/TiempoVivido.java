package ejercicio_por_consola_2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class TiempoVivido {
    public static void main(String[] args) {
        int edad = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite su edad: ");

        edad = scan.nextInt();

        String ms = "años: " + edad + "\nsiglos: " + edad * 0.01 +  "\ndecadas: " + edad * 0.1 + "\nsemestres: " + edad * 2
                + "\ntrimestres : " + edad * 4 + "\nbimestres: " + edad * 6 + "\nmeses: " + edad * 12 + "\nQuinsenas: "
                + edad * 24 + "\nsemana: " + edad * 52.143 + "\nDias: " + edad * 365 + "Jornadas \ndia: " + (edad * 365) / 4
                + "\nJornadas noche: " + (edad * 365) / 4 + "\nJornadas mañana: " + (edad * 365) / 4 + "\nJornadas tarde: "
                + (edad * 365) / 4 + "\nHoras: " + edad * 8760 + "\nMinutos: " + edad * 525600 + "\nSegundos: " + edad * 3.154
                + "\nDomingos: " + edad * 52.143 + "\nMili-segundos: " + edad * 3.154;

        System.out.println(ms);

    }
}

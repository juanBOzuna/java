/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  ejercicios_java.step_6;

import java.net.URL;
import java.net.URLConnection;

import java.io.*;

/**
 *
 * @author juan barraza
 */
public class prueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final String url = "https://jsonplaceholder.typicode.com/posts";
        System.out.println("Valor de la url asignado");
        
        try {
            URL route = new URL(url);
            URLConnection connection = route.openConnection();
            Reader reader = new InputStreamReader(connection.getInputStream());
            BufferedReader buffer = new BufferedReader(reader);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);

            }

        } catch (IOException e) {
            System.err.println("Excepcion: " + e.getMessage());
        }
    }

}

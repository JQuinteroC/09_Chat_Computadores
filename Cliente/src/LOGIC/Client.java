/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner a = new Scanner(System.in);
        Socket socket = new Socket("10.20.150.75", 500);

        // Entrada de datos
        InputStream it;
        InputStreamReader ent;
        BufferedReader entrada;
        it = socket.getInputStream();
        ent = new InputStreamReader(it);
        entrada = new BufferedReader(ent);

        // Salia de datos        
        OutputStream ot;
        OutputStreamWriter s;
        PrintWriter salida;
        ot = socket.getOutputStream();
        s = new OutputStreamWriter(ot);
        salida = new PrintWriter(s, true);

        //Enviar y recibir
        for (;;) {
            System.out.print("Digite numero.");
            System.out.println("-1 para terminar.");
            String dato = a.nextLine();
            //envia
            salida.println("" + dato);
            String m = entrada.readLine();
            if (m == null) {
                break;
            }
            System.out.println(m);
        }
        socket.close();
    }
}

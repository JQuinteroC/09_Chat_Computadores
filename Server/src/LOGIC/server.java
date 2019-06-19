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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class server {

    public static void main(String[] args) throws IOException {
        Scanner sc;
        sc = new Scanner(System.in);
        Socket cliente = null;
        ServerSocket ss;
        ss = new ServerSocket(500);
        cliente = ss.accept();

        // Entrada del cliente
        InputStream it;
        InputStreamReader e1;

        BufferedReader entrada;
        it = cliente.getInputStream();
        e1 = new InputStreamReader(it);
        entrada = new BufferedReader(e1);

        //Salida
        OutputStream ot;
        OutputStreamWriter s;
        PrintWriter salida;
        ot = cliente
                .getOutputStream();
        s = new OutputStreamWriter(ot);
        salida = new PrintWriter(s, true);
        /*    Ciclo donde se reciben
        mensajes del cliente en
        el servidor, se procesan y se envia la respuesta al cliente. */
        String mensaje;
        double n;
        for (;;) {
            // recibe mensaje
            mensaje = entrada.readLine();
            System.out.print("Digite r para raiz.");
            System.out.println("Otra letra para lg");
            String op = sc.nextLine();
            n = Double.parseDouble(mensaje);
            if (n < 0) {
                break;
            }
            if (op.charAt(0) == 'r') {
                n = Math.sqrt(n);
                salida.println("raiz=" + n);
            } else {
                n = Math.log(n)
                        / Math.log(2);
                salida.println("lg=" + n);
            }
        }
        entrada.close();
        salida.close();
        cliente.close();
    }
}


package baitap4;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); 

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap so nguyen N: ");
            String N = userInput.readLine();

            out.println(N);

            String result = in.readLine();
            System.out.println("Kq: " + result);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


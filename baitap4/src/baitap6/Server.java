
package baitap6;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); 

            System.out.println("Server dang cho ket noi...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); 

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                double a = Double.parseDouble(in.readLine());
                double b = Double.parseDouble(in.readLine());

                double sum = a + b;
                double difference = a - b;
                double product = a * b;
                double quotient = a / b;

                out.println("Tong: " + sum);
                out.println("Hieu: " + difference);
                out.println("Tich: " + product);
                out.println("Thuong: " + quotient);

                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


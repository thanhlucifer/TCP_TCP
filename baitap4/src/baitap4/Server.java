
package baitap4;

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

                String input = in.readLine();
                int sum = 0;

                for (int i = 0; i < input.length(); i++) {
                    char digit = input.charAt(i);
                    sum += Character.getNumericValue(digit);
                }

                out.println(sum);

                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


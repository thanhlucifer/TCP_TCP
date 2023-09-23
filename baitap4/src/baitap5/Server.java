
package baitap5;

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

                
                String N = in.readLine();
               
                String M = in.readLine();

                
                java.math.BigInteger bigN = new java.math.BigInteger(N);
                java.math.BigInteger bigM = new java.math.BigInteger(M);
                java.math.BigInteger sum = bigN.add(bigM);

                out.println(sum);

                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

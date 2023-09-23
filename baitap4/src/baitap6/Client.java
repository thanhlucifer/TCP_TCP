
package baitap6;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap sa thuc a: ");
            double a = Double.parseDouble(userInput.readLine());

            System.out.print("Nhap so thuc b: ");
            double b = Double.parseDouble(userInput.readLine());

            out.println(a);
            out.println(b);

            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

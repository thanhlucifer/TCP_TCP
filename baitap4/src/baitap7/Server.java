/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitap7;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.math.BigInteger;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Khởi tạo ServerSocket để lắng nghe kết nối từ Client
            ServerSocket serverSocket = new ServerSocket(12345); // Cổng 12345

            System.out.println("Server dang cho ket noi...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Chấp nhận kết nối từ Client

                // Mở luồng vào/ra để đọc gửi dữ liệu
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Đọc số nguyên N từ Client
                int N = Integer.parseInt(in.readLine());

                // Tính giai thừa của N
                BigInteger result = calculateFactorial(N);

                // Gửi kết quả về Client
                out.println(result.toString());

                // Đóng kết nối
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm tính giai thừa với số lớn hơn giới hạn của kiểu dữ liệu nguyên
    private static BigInteger calculateFactorial(int N) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}

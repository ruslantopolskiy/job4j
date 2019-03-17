package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private Socket socket;
    private static int port = 5050;
    private static String adress = "localhost";

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        String outServ;
        String inServ;
        System.out.println("Hello.");
        try (
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {
            do {
                System.out.println("Enter your message: ");
                out.println(outServ = keyIn.readLine());
                inServ = in.readLine();
                while (!inServ.isEmpty()) {
                    System.out.println(inServ);
                    inServ = in.readLine();
                }
            } while (!outServ.equalsIgnoreCase("exit"));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        try {final Socket socket = new Socket(InetAddress.getByName(adress),port);
            new Client(socket).start();

        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
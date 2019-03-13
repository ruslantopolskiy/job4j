package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        String input;
        System.out.println("Server started, wait user's");
        try (Socket socket = new ServerSocket(this.port).accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {
            if (socket.isConnected()){
                System.out.println("*User connected*");
            }
            do {
                input = in.readLine();
                System.out.println(input);
                if (input.equals("Hello") | (input.equals("hello"))) {
                    out.println("Hello, dear friend, I'm a oracle.");
                } else {
                    out.println("It's an Oracle, you said : " + input);
                }
            } while (!input.equals("Exit") | (!input.equals("exit")));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server(5050).start();
    }
}
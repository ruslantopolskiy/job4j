package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        String input;
        System.out.println("Server started, wait user's");
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true)) {
            if (socket.isConnected()) {
                System.out.println("*User connected*");
            }
            do {
                input = in.readLine();
                System.out.println(input);
                if (input.equals("Hello") | input.equals("hello")) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                } else if (!input.equalsIgnoreCase("exit")) {
                    out.println("It's an Oracle, you said : " + input);
                    out.println();
                }
            } while (!input.equalsIgnoreCase("exit"));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        try (final Socket socket = new ServerSocket(5050).accept()) {
            new Server(socket).start();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
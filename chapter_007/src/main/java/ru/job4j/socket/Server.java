package ru.job4j.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        try {
            try {
                serverSocket = new ServerSocket(5050);
                System.out.println("***Сервер запущен, ожидание пользователя***");
                socket = serverSocket.accept();
                System.out.println("***Пользователь подключился***");
                System.out.println();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                String ask;
                do {
                    System.out.println("***Ожидание команды***");
                    ask = in.readLine();
                    System.out.println(ask);
                    out.write("Это сервер, подтверждаю вы написали : " + ask);
                    if (ask.equals("Hello")) {
                        out.write("Hello, dear friend. I'm a oracle.");
                        out.println();
                    }
                }
                 while (!ask.equals("Exit"));
            } finally {
                socket.close();
                in.close();
                out.close();
                serverSocket.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

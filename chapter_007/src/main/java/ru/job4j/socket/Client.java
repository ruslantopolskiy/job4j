package ru.job4j.socket;

import java.io.*;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    private static BufferedReader in;
    private static PrintWriter out;
    private static BufferedReader reader;
    private static Socket socket;
    private static String address = "127.0.0.1";
    private static InetAddress inetAddress;

    public static void main(String[] args) {
        try {
            try {
                inetAddress = InetAddress.getByName(address);
                System.out.println("Any of you heard of a socket with IP address " + address + " and port 5050.");
                socket = new Socket(inetAddress, 5050);
                System.out.println("Yes! I just got hold of the program.");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
                reader = new BufferedReader(new InputStreamReader(System.in));
                String input;
                String output;
                do {
                    System.out.println("Вы что-то хотели сказать? Введите это здесь:");
                    input = reader.readLine();
                    out.println(input);
                    output = in.readLine();
                    while (!output.isEmpty()){
                        System.out.println(output);
                        output = in.readLine();
                    }
                } while (!input.equals("Exit"));
            }finally {
                socket.close();
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
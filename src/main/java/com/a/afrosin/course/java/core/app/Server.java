package com.a.afrosin.course.java.core.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        final int PORT = 8189;
        final String  exitWord= "/end";

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");

            ThreadReader threadReader = new ThreadReader(socket, "ServerReader", exitWord);
            threadReader.t.start();

            ThreadWriter threadWriter = new ThreadWriter(socket, "ServerWriter", exitWord);
            threadWriter.t.start();

            threadReader.t.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Сервер остановлен");
    }
}

package com.a.afrosin.course.java.core.app;

import java.io.IOException;
import java.net.Socket;

public class Client {
    static Socket socket;
    static final String  exitWord= "/end";

    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        try {
            openConnection(SERVER_ADDR, SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void openConnection(String serverAddr, int ServerPort) throws IOException {

        socket = new Socket(serverAddr, ServerPort);

        ThreadReader threadReader = new ThreadReader(socket, "ClientReader", "");
        threadReader.t.start();

        ThreadWriter threadWriter = new ThreadWriter(socket, "ClientWriter", exitWord);
        threadWriter.t.start();
    }
}

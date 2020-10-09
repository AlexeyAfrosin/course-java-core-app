package com.a.afrosin.course.java.core.app;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadReader implements Runnable {

    Socket socket;
    Thread t;
    DataInputStream inStream;
    String exitWord;
    SimpleDateFormat formatter;

    public ThreadReader(Socket socket, String name, String exitWord) {
        this.formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.socket = socket;
        this.t = new Thread(this, name);
        this.exitWord = exitWord;
        try {
            this.inStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!t.isInterrupted()) {
                String readedStr = inStream.readUTF();

                System.out.println(formatter.format(new Date()));
                System.out.printf("%s: %s\n", t.getName(), readedStr);

                if (readedStr.equals(exitWord)) {
                    System.out.println("Получена команда остановки!");
                    break;
                }

            }
            inStream.close();
        } catch (SocketException | EOFException e) {
            System.out.println("Соединение разорвано");
        } catch (Exception e) {
            try {
                inStream.close();
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
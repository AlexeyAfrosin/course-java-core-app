package com.a.afrosin.course.java.core.app;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class ThreadWriter implements Runnable {

    Socket socket;
    Thread t;
    DataOutputStream outStream;
    Scanner scClientMessages;
    SimpleDateFormat formatter;
    String exitWord;

    public ThreadWriter(Socket socket, String name, String exitWord) {
        this.formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.socket = socket;
        this.t = new Thread(this, name);
        this.t.setDaemon(true);
        this.exitWord = exitWord;
        try {
            this.outStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.scClientMessages = new Scanner(System.in);
    }

    @Override
    public void run() {
        try {
            while (!t.isInterrupted()) {
                String readedStr = scClientMessages.nextLine();
                System.out.println(formatter.format(new Date()));
                System.out.printf("%s: %s\n", t.getName(), readedStr);
                outStream.writeUTF(readedStr);
            }
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
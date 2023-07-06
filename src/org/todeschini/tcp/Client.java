package org.todeschini.tcp;

import java.io.*;
import java.net.Socket;

public class Client {

    public Client() throws IOException {
        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successful connection");

        // I/O Stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        String msg = reader.readLine();
        System.out.println(msg);

        out.println("Thank!");
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

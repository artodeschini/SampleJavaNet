package org.todeschini.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() throws IOException {
        ServerSocket server = new ServerSocket(2020);
        System.out.println("Server start and user port 2020");

        Socket socket = server.accept();
        System.out.println("client connect " + socket.getInetAddress() + " has connect");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(),true);

        outSocket.println("Welcome "); // mesg to send to client
        String msg = inSocket.readLine(); // the client says
        System.out.println("The client msg is:" + msg);

        socket.close();
        System.out.println("socket was close");
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

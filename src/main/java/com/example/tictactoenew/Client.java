package com.example.tictactoenew;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String host = "Whatever";
        int port = 80;

        try (Socket socket = new Socket(host, port)) {
            String request = """
                    GET / HTTP/1.1
                    Host: Whatever
                    Connection: close
                    
                    """;
            //Alt1: Convert string to byte
            socket.getOutputStream().write(request.getBytes());
            // Alt2: Use a PrintWriter instead
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(request);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

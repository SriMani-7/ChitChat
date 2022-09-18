package com.ithoughts.fun.chitchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ChatRoom receiver;
        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            Socket client = serverSocket.accept();
            receiver = new ChatRoom();
            receiver.getReady(
                    client.getInputStream(),
                    client.getOutputStream()
            );
            receiver.receiveChat();
            receiver.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

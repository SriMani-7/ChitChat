package com.ithoughts.fun.chitchat;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        ChatRoom sender;
        try (Socket client = new Socket("localhost", 1111)) {
            sender = new ChatRoom();
            sender.getReady(
                    client.getInputStream(),
                    client.getOutputStream()
            );
            sender.startChatting();
            sender.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

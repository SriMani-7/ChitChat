package com.ithoughts.fun.chitchat;

import java.io.*;

public class ChatRoom implements Closeable {
    private ChatUser chatUser;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private BufferedReader reader;

    public ChatRoom() throws IOException {
        System.out.println("|||| Welcome to ChitChat ||||");
        System.out.print("Enter your name :: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        chatUser = new ChatUser(reader.readLine());
    }

    public void getReady(InputStream input, OutputStream output) throws IOException {
        inputStream = new DataInputStream(input);
        outputStream = new DataOutputStream(output);
        outputStream.writeUTF(chatUser.getName());
        outputStream.flush();
        chatUser.setOther(inputStream.readUTF());
        System.out.println("Connected to ... " + chatUser.getOther() + "\n\n===========================");
    }

    public void startChatting() throws IOException {
        String message = "";
        while (!message.equals("STOP")) {
            System.out.print("Me : ");
            message = reader.readLine();
            outputStream.writeUTF(message);
            outputStream.flush();
            System.out.println(chatUser.getOther() + " : " + inputStream.readUTF());
        }
    }

    public void receiveChat() throws IOException {
        String message = "";
        while (!message.equals("STOP")) {
            System.out.println(chatUser.getOther() + " : " + inputStream.readUTF());
            System.out.print("Me : ");
            message = reader.readLine();
            outputStream.writeUTF(message);
            outputStream.flush();
        }
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
        outputStream.close();
        reader.close();
    }
}

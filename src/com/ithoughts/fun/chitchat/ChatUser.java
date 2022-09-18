package com.ithoughts.fun.chitchat;

public class ChatUser {
    private String name;
    private String other;

    public ChatUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}

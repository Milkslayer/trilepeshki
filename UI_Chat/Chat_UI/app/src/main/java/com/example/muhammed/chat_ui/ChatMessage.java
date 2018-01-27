package com.example.muhammed.chat_ui;

/**
 * Created by Muhammed on 27.01.2018.
 */

public class ChatMessage {
    private String messageText;
    private long messageTime;

    public ChatMessage() {
    }

    public ChatMessage(String messageText, long messageTime) {
        this.messageText = messageText;
        this.messageTime = messageTime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}

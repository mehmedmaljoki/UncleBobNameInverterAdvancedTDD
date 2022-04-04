package com.meski.accademy.mail;

public class MailBox {
    private int messageCount = 0;

    public int getMessageCount() {
        return messageCount;
    }

    public void addMessage(MailMessage message) {
        messageCount++;
    }
}

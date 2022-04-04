package com.meski.accademy.mail;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MailTest {
    @Test
    public void newMailBox_isEmpty() throws Exception {
        MailBox mailbox = new MailBox();
        assertThat(mailbox.getMessageCount(), equalTo(0));
    }

    @Test
    public void whenAMessageIsAdded_MessageCountWillBeOne() throws Exception {
        MailBox mailbox = new MailBox();
        MailMessage message = new MailMessage();
        mailbox.addMessage(message);
        assertThat(mailbox.getMessageCount(), equalTo(1));
    }
}

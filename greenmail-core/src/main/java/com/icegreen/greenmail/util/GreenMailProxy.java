package com.icegreen.greenmail.util;

import com.icegreen.greenmail.Managers;
import com.icegreen.greenmail.imap.ImapServer;
import com.icegreen.greenmail.pop3.Pop3Server;
import com.icegreen.greenmail.smtp.SmtpServer;
import com.icegreen.greenmail.user.GreenMailUser;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Proxy that routes all operations to an internal greenmail instance
 */
public abstract class GreenMailProxy implements GreenMailOperations {
    @Override
    public SmtpServer getSmtp() {
        return getGreenMail().getSmtp();
    }

    @Override
    public ImapServer getImap() {
        return getGreenMail().getImap();
    }

    @Override
    public Pop3Server getPop3() {
        return getGreenMail().getPop3();
    }

    @Override
    public SmtpServer getSmtps() {
        return getGreenMail().getSmtps();
    }

    @Override
    public ImapServer getImaps() {
        return getGreenMail().getImaps();
    }

    @Override
    public Pop3Server getPop3s() {
        return getGreenMail().getPop3s();
    }

    @Override
    public Managers getManagers() {
        return getGreenMail().getManagers();
    }

    @Override
    public boolean waitForIncomingEmail(long timeout, int emailCount) {
        return getGreenMail().waitForIncomingEmail(timeout, emailCount);
    }

    @Override
    public boolean waitForIncomingEmail(int emailCount) {
        return getGreenMail().waitForIncomingEmail(emailCount);
    }

    @Override
    public MimeMessage[] getReceivedMessages() {
        return getGreenMail().getReceivedMessages();
    }

    @Override
    public MimeMessage[] getReceviedMessagesForDomain(String domain) {
        return getGreenMail().getReceviedMessagesForDomain(domain);
    }

    @Override
    public GreenMailUser setUser(String login, String password) {
        return getGreenMail().setUser(login, password);
    }

    @Override
    public GreenMailUser setUser(String email, String login, String password) {
        return getGreenMail().setUser(email, login, password);
    }

    @Override
    public void setUsers(Properties users) {
        getGreenMail().setUsers(users);
    }

    @Override
    public void setQuotaSupported(boolean isEnabled) {
        getGreenMail().setQuotaSupported(isEnabled);
    }

    @Override
    public void start() {
        getGreenMail().start();
    }

    @Override
    public void stop() {
        getGreenMail().stop();
    }

    @Override
    public void reset() {
        getGreenMail().reset();
    }

    /**
     * @return Greenmail instance provided by child class
     */
    protected abstract GreenMail getGreenMail();
}

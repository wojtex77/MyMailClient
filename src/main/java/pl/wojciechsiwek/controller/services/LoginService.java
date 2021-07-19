package pl.wojciechsiwek.controller.services;

import pl.wojciechsiwek.EmailManager;
import pl.wojciechsiwek.controller.EmailLoginResult;
import pl.wojciechsiwek.model.EmailAccount;

import javax.mail.*;

public class LoginService {
    EmailAccount emailAccount;
    EmailManager emailManager;

    public LoginService(EmailAccount emailAccount, EmailManager emailManager) {
        this.emailAccount = emailAccount;
        this.emailManager = emailManager;
    }

    public EmailLoginResult login() {
        Authenticator authenticator = new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAccount.getAddress(), emailAccount.getPassword());
            }
        };

        try {
            Session session = Session.getInstance(emailAccount.getProperties(), authenticator);
            Store store = session.getStore("imaps");
            store.connect(emailAccount.getProperties().getProperty("incomingHost"),
                    emailAccount.getAddress(),
                    emailAccount.getPassword());
            emailAccount.setStore(store);

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_UNEXPEECTED_ERROR;
        } catch (AuthenticationFailedException e){
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_CREDENTIALS;
        } catch (MessagingException e) {
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_UNEXPEECTED_ERROR;
        } catch (Exception e){
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_UNEXPEECTED_ERROR;
        }
        return EmailLoginResult.SUCCESS;
    }
}

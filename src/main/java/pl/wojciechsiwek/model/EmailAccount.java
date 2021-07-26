package pl.wojciechsiwek.model;

import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {

    private String address;
    private String password;
    private Properties properties;
    private Store Store;

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        this.properties = new Properties();

        properties.put("incomingHost", "imap.gmail.com");
        properties.put("mail.store.protocol", "imaps");

        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.auth", "true");
        properties.put("outgoingHost", "smtp.gmail.com");
    }

    public String getAddress() {
        return address;
    }


    public String getPassword() {
        return password;
    }
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public javax.mail.Store getStore() {
        return Store;
    }

    public void setStore(javax.mail.Store store) {
        Store = store;
    }
}

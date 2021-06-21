package pl.wojciechsiwek.view;

import pl.wojciechsiwek.EmailManager;

public class ViewFactory {

    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void showLoginWindow (){
        System.out.println("it works!");
    }
}

package pl.wojciechsiwek.controller;

import pl.wojciechsiwek.EmailManager;
import pl.wojciechsiwek.view.ViewFactory;

public abstract class BaseController {
    protected EmailManager emailManager;
    protected ViewFactory viewFactory;
    String fxmlName;

    public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}

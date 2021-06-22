package pl.wojciechsiwek.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.wojciechsiwek.EmailManager;
import pl.wojciechsiwek.view.ViewFactory;

public class LoginWindowController extends BaseController{

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabel;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        System.out.println("loginButtonAction");
        viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
        System.out.println("loginWindowClosed");
    }

}

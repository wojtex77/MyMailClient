package pl.wojciechsiwek.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.wojciechsiwek.EmailManager;
import pl.wojciechsiwek.controller.services.LoginService;
import pl.wojciechsiwek.model.EmailAccount;
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
        if (fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event -> {
                EmailLoginResult emailLoginResult = loginService.getValue();

                switch (emailLoginResult) {
                    case SUCCESS:
                        System.out.println("login success: "+emailAccount);
                        viewFactory.showMainWindow();
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                        System.out.println("loginWindowClosed");
                        return;

                }
            });
        }
    }

    private boolean fieldsAreValid() {
        if (emailAddressField.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        if (passwordField.getText().isEmpty()){
            errorLabel.setText("Please fill password");
            return false;
        }
        else return true;    }

}

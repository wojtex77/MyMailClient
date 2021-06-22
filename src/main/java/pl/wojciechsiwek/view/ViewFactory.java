package pl.wojciechsiwek.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.wojciechsiwek.EmailManager;
import pl.wojciechsiwek.controller.BaseController;
import pl.wojciechsiwek.controller.LoginWindowController;
import pl.wojciechsiwek.controller.MainWindowController;
import pl.wojciechsiwek.controller.OptionWindowController;

import java.io.IOException;

public class ViewFactory {

    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    private void initializeStage (BaseController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();
    }

    public void showLoginWindow (){
        System.out.println("Login window called");
        BaseController controller = new LoginWindowController(emailManager, this, "/LoginWindow.fxml");
        initializeStage(controller);
    }
    public void showOptionsWindow (){
        System.out.println("Options window called");
        BaseController controller = new OptionWindowController(emailManager, this, "/OptionsWindow.fxml");
        initializeStage(controller);
    }
    public void showMainWindow(){
        System.out.println("Main window called");
        BaseController controller = new MainWindowController(emailManager, this, "/MainWindow.fxml");
        initializeStage(controller);
    }
}

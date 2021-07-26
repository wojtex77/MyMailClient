package pl.wojciechsiwek;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.wojciechsiwek.view.ViewFactory;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();
        }
}

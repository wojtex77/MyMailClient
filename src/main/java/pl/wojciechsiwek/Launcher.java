package pl.wojciechsiwek;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent parent;
        parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/LoginWindowController.fxml")));

        Scene scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }
}

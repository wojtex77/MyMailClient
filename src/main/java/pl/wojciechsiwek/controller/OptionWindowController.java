package pl.wojciechsiwek.controller;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import pl.wojciechsiwek.EmailManager;
import pl.wojciechsiwek.view.ViewFactory;

public class OptionWindowController extends BaseController {

    public OptionWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<?> themePicker;

    @FXML
    void applyButtonAction() {

    }

    @FXML
    void cancelButtonAction() {
        Stage stage = (Stage) themePicker.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

}

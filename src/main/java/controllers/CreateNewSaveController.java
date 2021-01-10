package controllers;

import controllers.app.IAppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewSaveController extends AbstractController {
    @FXML private Button createSaveButton;
    @FXML private Button backButton;
    @FXML private TextField saveName;

    public CreateNewSaveController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.createSaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                if(saveName.getText() != null && saveName.getText().length() > 0){
                    if(createNewSave(saveName.getText())){
                        saveCharged();
                        startGame();
                        goToSettings();
                    }
                }
            }
        });
        this.backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                goToSettings();
            }
        });
    }
}

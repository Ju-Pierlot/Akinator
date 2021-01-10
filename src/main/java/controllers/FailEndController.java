package controllers;

import controllers.app.IAppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class FailEndController extends AbstractController {
    @FXML private Button yesButton;
    @FXML private Button noButton;
    @FXML private Button goToMenuButton;

    public FailEndController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.yesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                goToGameProgress();
            }
        });
        this.noButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                comeFromFail();
                goToAddOneCharacter();
            }
        });
        this.goToMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                goToMenu();
            }
        });
    }
}

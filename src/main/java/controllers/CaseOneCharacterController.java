package controllers;

import controllers.app.IAppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class CaseOneCharacterController extends AbstractController {
    @FXML private Label characterName;
    @FXML private Button yesB;
    @FXML private Button noB;
    @FXML private ImageView card;

    public CaseOneCharacterController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String message = "Tu as choisi " + getLastCharacterName() + " comme personnage! Suis-je le best ?";
        this.card.setImage(new Image(getLastCharacterImage()));
        this.characterName.setText(message);
        this.yesB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                goToSuccessEnd();
            }
        });
        this.noB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                goToFailEnd();
            }
        });
    }
}

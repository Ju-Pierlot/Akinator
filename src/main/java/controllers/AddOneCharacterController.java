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

public class AddOneCharacterController extends AbstractController {
    @FXML private Button nextButton;
    @FXML private Button backButton;
    @FXML private TextField characterName;
    @FXML private TextField characterImage;
    @FXML private TextField questionTitle;

    public AddOneCharacterController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                if(characterName.getText() != null && characterName.getText().length() > 0){
                    if(questionTitle.getText() != null && questionTitle.getText().length() > 0){
                        String image = "";
                        if(characterImage.getText() != null && characterImage.getText().length() > 0){
                            image = characterImage.getText();
                        }
                        addNewCharacter(characterName.getText(), characterImage.getText(), questionTitle.getText());
                        goToMenu();
                    }
                }
            }
        });
        this.backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                if(isComeFromFail()) goToFailEnd();
                if(isComeFromSuccess()) goToSuccessEnd();
                if(isComeFromMoreCharacter()) goToCaseMoreCharacter();
            }
        });
    }
}

package controllers;

import controllers.app.IAppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameProgressController extends AbstractController{
    @FXML private Label questionTitle;
    @FXML private Button yesButton;
    @FXML private Button noButton;
    @FXML private Button idkButton;
    @FXML private Button backButton;

    public GameProgressController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reloadGame();
        this.questionTitle.setText(this.getNextQuestion());

        this.yesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                removeAKey(true);
            }
        });
        this.noButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                removeAKey(false);
            }
        });
        this.idkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                removeLastQuestion();
                if(!noQuestionLeft()) questionTitle.setText(getNextQuestion());
                else goToCaseMoreCharacter();
            }
        });
        this.backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                if(canGoBackQuestion()){
                    String question = getLastQuestionTitle();
                    if(question.length() > 0) questionTitle.setText(question);
                }
            }
        });
    }
    private void removeAKey(boolean have){
        removeKeyboolean(have);
        if(!noQuestionLeft()){
            if(getCharactersSize() > 1){
                questionTitle.setText(getNextQuestion());
            } else if(getCharactersSize() == 0){
                goToNoCharactersLeft();
            } else {
                goToCaseOneCharacter();
            }
        } else {
            if(getCharactersSize() == 0){
                goToNoCharactersLeft();
            } else if(getCharactersSize() == 1){
                goToCaseOneCharacter();
            } else {
                goToCaseMoreCharacter();
            }
        }
    }

}

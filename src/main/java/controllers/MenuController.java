package controllers;

import controllers.app.IAppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends AbstractController {
    @FXML private Button playButton;
    @FXML private Button settingsButton;
    @FXML private Button quitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!this.isSaveCharged()) this.playButton.setDisable(true);

        this.playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                play();
            }
        });
        this.settingsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                settings();
            }
        });

        this.quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                quit();
            }
        });
    }
    public MenuController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
    }
    private void play(){
        this.goToGameProgress();
    }
    private void settings(){
        this.goToSettings();
    }
    private void quit(){
        System.out.println("[Action asked] : Quit");
        this.exit();
    }
}

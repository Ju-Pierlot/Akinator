package controllers;

import controllers.app.IAppController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController extends AbstractController {
    @FXML private Button chargeSaveButton;
    @FXML private Button modifyButton;
    @FXML private Button backButton;

    private URL url;

    public SettingsController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
        this.url = url;

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!this.isSaveCharged()) this.modifyButton.setText("Nouvelle sauvegarde");
        else this.modifyButton.setText("Modifier");
        this.chargeSaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                System.out.println("[Action asked] : Charging file...");
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(getPrimaryActivity());
                if (file != null) {
                    openFile(file);
                } else{
                    System.out.println("\033[33m" + "[Warning] Charging file canceled" + "\033[30m");
                }
            }
        });
        this.modifyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                if(!isSaveCharged()) goToCreateNewSave();
                else goToModifySave();
            }
        });
        this.backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                menu();
            }
        });
    }
    @Override
    public URL getURL() {
        return this.url;
    }
    private void menu(){
        this.goToMenu();
    }
    private void openFile(File file){
        if(this.chargeFile(file)){
            modifyButton.setText("Modifier");
            saveCharged();
            this.startGame();
            System.out.println("\033[32m" + "[Success] : File charged" + "\033[30m");
        } else {
            System.out.println("\033[31m" + "[Error] File upload failed" + "\033[30m");
        }
    }
}

package controllers;

import controllers.app.IAppController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import model.characters.Character;
import model.collections.ObservableObject;

import java.net.URL;
import java.util.ResourceBundle;

public class CaseMoreCharacterController extends AbstractController{
    @FXML private ListView<Character> list;
    @FXML private Button selectButton;
    @FXML private Button goToMenuButton;
    @FXML private Button addButton;

    private ObservableList<Character> characters;

    public CaseMoreCharacterController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.characters = new ObservableObject<>();
        this.characters.addAll(getCharactersLeft());
        this.list.setItems(characters);
        this.selectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                if(list.getSelectionModel().getSelectedItem() != null){
                    setCharacterToModify(list.getSelectionModel().getSelectedItem());
                    goToModifyCharacter();
                }
            }
        });
        this.goToMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                goToMenu();
            }
        });
        this.addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                comeFromMoreCharacter();
                goToAddOneCharacter();
            }
        });
    }

}

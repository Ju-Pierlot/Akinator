package controllers;

import controllers.app.IAppController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import model.characters.Character;
import model.collections.ObservableObject;
import model.questions.Question;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifySaveController extends AbstractController {
    @FXML private ListView<Character> characterList;
    private ObservableList<Character> characters;

    @FXML private ListView<Question> questionList;
    private ObservableList<Question> questions;

    @FXML private Button deleteQuestionButton;
    @FXML private Button addQuestionButton;
    @FXML private Button modifyQuestionButton;
    @FXML private Button deleteCharacterButton;
    @FXML private Button addCharacterButton;
    @FXML private Button haveButton;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;

    @FXML private TextField questionTitle;
    @FXML private TextField imagePath;
    @FXML private TextField characterName;

    public ModifySaveController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.characters = new ObservableObject<>();
        this.characters.addAll(getCharactersList());
        this.characterList.setItems(characters);

        this.questions = new ObservableObject<>();
        this.questions.addAll(getQuestionsList());
        this.questionList.setItems(questions);

        this.characterList.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> c) {
                if(characterList.getSelectionModel().getSelectedItem() != null){
                    characterName.setText(characterList.getSelectionModel().getSelectedItem().getName());
                    imagePath.setText(characterList.getSelectionModel().getSelectedItem().getImagePath());
                }
                updateButton();
            }
        });
        this.questionList.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> c) {
                if(questionList.getSelectionModel().getSelectedItem() != null){
                    questionTitle.setText(questionList.getSelectionModel().getSelectedItem().getTitle());
                }
                updateButton();
            }
        });

        this.deleteQuestionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                deleteQuestion();
            }
        });
        this.addQuestionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(questionTitle.getText() != null && questionTitle.getText().length() > 0){
                    questions.add(new Question(questionTitle.getText(), Integer.toString(questions.size()+questionTitle.getText().length())+
                            questionTitle.getText().substring(0, (int)(Math.random()*questionTitle.getText().length()))));
                    questionTitle.setText("");
                }
                updateQuestionList();
                startTok();
            }
        });
        this.modifyQuestionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Question question = questionList.getSelectionModel().getSelectedItem();
                if(question != null){
                    if(questionTitle.getText() != null && questionTitle.getText().length() > 0){
                        question.setTitle(questionTitle.getText());
                    }
                }
                updateQuestionList();
                startTok();
            }
        });
        this.deleteCharacterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                characters.remove(characterList.getSelectionModel().getSelectedItem());
                updateCharacterList();
                characterName.setText("");
                imagePath.setText("");
            }
        });
        this.addCharacterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                if(characterName.getText().length() > 0){
                    characters.add(new Character(characterName.getText(), imagePath.getText()));
                    updateCharacterList();
                    characterName.setText("");
                    imagePath.setText("");
                }
            }
        });
        this.haveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                updateCharacter();
            }
        });
        this.saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                saveModifyBank(questions, characters);
                goToSettings();
            }
        });
        this.cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTok();
                goToSettings();
            }
        });
    }
    private void updateButton(){
        Character character = characterList.getSelectionModel().getSelectedItem();
        Question question = questionList.getSelectionModel().getSelectedItem();
        if (character != null && question != null) {
            if(character.haveKey(question.getKey())){
                this.haveButton.setText("Oui");
            } else {
                this.haveButton.setText("Non");
            }
        }
    }
    private void updateCharacter(){
        Character character = characterList.getSelectionModel().getSelectedItem();
        Question question = questionList.getSelectionModel().getSelectedItem();
        if (character != null && question != null) {
            if(character.haveKey(question.getKey())){
                character.removeKey(question.getKey());
            } else {
                character.addKey(question.getKey());
            }
        }
        updateButton();
    }
    private void deleteQuestion(){
        Question question = questionList.getSelectionModel().getSelectedItem();
        questions.remove(question);
        for (Character character: characters) {
            character.removeKey(question.getKey());
        }
        updateQuestionList();
        questionTitle.setText("");
    }
    private void updateCharacterList(){
        characterList.setItems(null);
        characterList.setItems(characters);
    }
    private void updateQuestionList(){
        questionList.setItems(null);
        questionList.setItems(questions);
    }
}

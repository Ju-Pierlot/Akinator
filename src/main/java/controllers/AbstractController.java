package controllers;

import controllers.app.AppController;
import controllers.app.IAppController;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.characters.Character;
import model.questions.Question;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;

public abstract class AbstractController implements Initializable {
    @FXML StackPane stackPane;
    @FXML AnchorPane anchorPane;

    private IAppController appController;
    private Stage primaryStage;
    private URL url;
    private MediaPlayer mediaPlayer;

    public AbstractController(IAppController appController, Stage primaryStage, Media media, URL url){
        this.appController = appController;
        this.primaryStage = primaryStage;
        this.url = url;
        if (media != null){
            this.mediaPlayer = new MediaPlayer(media);
            this.mediaPlayer.setVolume(0.5);
        }
    }
    public URL getURL(){
        return this.url;
    }
    public void exit(){
        this.primaryStage.close();
    }
    public void goToSettings(){
        System.out.println("[Action asked] : Loading settings...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getSettingsUrl());
        chargerFXML.setController(this.appController.getSettingsController());
        lunchNewScene(chargerFXML);

    }
    public void goToMenu(){
        System.out.println("[Action asked] : Loading menu...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getMenuUrl());
        chargerFXML.setController(this.appController.getMenuController());
        lunchNewScene(chargerFXML);
    }
    public void goToGameProgress(){
        System.out.println("[Action asked] : Loading game...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getGameProgressUrl());
        chargerFXML.setController(this.appController.getGameProgressController());
        lunchNewScene(chargerFXML);
    }
    public void goToCaseOneCharacter(){
        System.out.println("[Action asked] : Loading character found...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getCaseOneCharacterUrl());
        chargerFXML.setController(this.appController.getCaseOneCharacterController());
        lunchNewScene(chargerFXML);
    }
    public void goToSuccessEnd(){
        System.out.println("[Action asked] : Loading success end...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getSuccessEndUrl());
        chargerFXML.setController(this.appController.getSuccessEndController());
        lunchNewScene(chargerFXML);
    }
    public void goToFailEnd(){
        System.out.println("[Action asked] : Loading fail end...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getFailEndUrl());
        chargerFXML.setController(this.appController.getFailEndController());
        lunchNewScene(chargerFXML);
    }
    public void goToAddOneCharacter(){
        System.out.println("[Action asked] : Loading add one character...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getAddOneCharacterUrl());
        chargerFXML.setController(this.appController.getAddOneCharacterController());
        lunchNewScene(chargerFXML);
    }
    public void goToCaseMoreCharacter(){
        System.out.println("[Action asked] : Loading character not found...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getCaseMoreCharacterUrl());
        chargerFXML.setController(this.appController.getCaseMoreCharacterController());
        lunchNewScene(chargerFXML);
    }
    public void goToModifyCharacter(){
        System.out.println("[Action asked] : Loading modify character...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getModifyCharacterUrl());
        chargerFXML.setController(this.appController.getModifyCharacterController());
        lunchNewScene(chargerFXML);
    }
    public void goToNoCharactersLeft(){
        System.out.println("[Action asked] : Loading no characters left...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getNoCharactersLeftUrl());
        chargerFXML.setController(this.appController.getNoCharactersLeftController());
        lunchNewScene(chargerFXML);
    }
    public void goToCreateNewSave(){
        System.out.println("[Action asked] : Loading create new save...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getCreateNewSaveUrl());
        chargerFXML.setController(this.appController.getCreateNewSaveController());
        lunchNewScene(chargerFXML);
    }
    public void goToModifySave(){
        System.out.println("[Action asked] : Loading modify save...");
        FXMLLoader chargerFXML = new FXMLLoader(this.appController.getModifySaveUrl());
        chargerFXML.setController(this.appController.getModifySaveController());
        lunchNewScene(chargerFXML);
    }
    private void lunchNewScene(FXMLLoader chargerFXML){
        try{
            Parent root = chargerFXML.load();
            Scene scene = this.primaryStage.getScene();

            root.translateXProperty().set(scene.getWidth());

            StackPane parentContainer = (StackPane) scene.getRoot();
            parentContainer.getChildren().add(root);

            Timeline timeLine = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.DISCRETE);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.01), kv);
            timeLine.getKeyFrames().add(kf);
            timeLine.setOnFinished(event -> {
                parentContainer.getChildren().remove(this.anchorPane);
            });
            timeLine.play();
            System.out.println("\033[32m" + "[Success] : Loading success" + "\033[30m");
        } catch (Exception e){
            System.out.println("\033[31m" + "[Error] Loading failed" + "\033[30m");
        }

    }
    public void startApplication(){
        try{
            System.out.println("[Action asked] : Loading menu...");
            FXMLLoader chargerFXML = new FXMLLoader(this.appController.getMenuUrl());
            chargerFXML.setController(this.appController.getMenuController());

            Parent root = chargerFXML.load();
            Scene scene = this.primaryStage.getScene();

            root.translateXProperty().set(scene.getWidth());
            this.stackPane.getChildren().add(root);

            Timeline timeLine = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.DISCRETE);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            timeLine.getKeyFrames().add(kf);
            timeLine.setOnFinished(event -> {
                this.stackPane.getChildren().remove(this.anchorPane);
            });
            timeLine.play();
            System.out.println("\033[32m" + "[Success] : Loading success" + "\033[30m");
        } catch (Exception e){
            System.out.println("\033[31m" + "[Error] Loading failed" + "\033[30m");
        }
    }
    public void startTok(){
        if(this.mediaPlayer != null){
            this.mediaPlayer.stop();
            this.mediaPlayer.play();
        }
    }
    public void saveCharged(){
        this.appController.saveCharged();
    }
    public boolean isSaveCharged(){
        return this.appController.isFileCharged();
    }
    public Stage getPrimaryActivity(){
        return this.primaryStage;
    }
    public boolean chargeFile(File file){
        return this.appController.setFile(file);
    }
    public String getNextQuestion(){
        return this.appController.getNextQuestion();
    }
    public void startGame(){
        this.appController.startGame();
    }
    public void removeKeyboolean(boolean have){
        this.appController.removeKeys(have);
    }
    public void reloadGame(){
        this.appController.reloadGame();
    }
    public int getCharactersSize(){
        return this.appController.getCharactersSize();
    }
    public boolean noQuestionLeft(){
        return this.appController.noQuestionLeft();
    }
    public void removeLastQuestion(){
        this.appController.removeLastQuestion();
    }
    public String getLastCharacterName(){
        return this.appController.getLastCharacterName();
    }
    public void addNewCharacter(String characterName, String characterImage, String question){
        this.appController.addNewCharacter(characterName, characterImage, question);
    }
    public void comeFromFail(){
        this.appController.comeFromFail();
    }
    public void comeFromSuccess(){
        this.appController.comeFromSuccess();
    }
    public void comeFromMoreCharacter(){
        this.appController.comeFromMoreCharacter();
    }
    public boolean isComeFromFail(){
        return this.appController.getComeFrom(AppController.COME_FROM_FAIL_END);
    }
    public boolean isComeFromSuccess(){
        return this.appController.getComeFrom(AppController.COME_FROM_SUCCESS_END);
    }
    public boolean isComeFromMoreCharacter(){
        return this.appController.getComeFrom(AppController.COME_FROM_MORE_CHARACTER);
    }
    public List<Character> getCharactersLeft(){
        return this.appController.getCharactersLeft();
    }

    public void setCharacterToModify(Character character) {
        this.appController.setCharacterToModify(character);
    }

    public void setNewParamToCharacterModify(String name, String image, String question) {
        this.appController.setNewParamToCharacterToModify(name, image, question);
    }

    public String getCharacterToModifyName() {
        return this.appController.getCharacterToModifyName();
    }

    public String getCharacterToModifyImage() {
        return this.appController.getCharacterToModifyImage();
    }
    public boolean canGoBackQuestion(){
        return this.appController.canGoBackQuestion();
    }
    public String getLastQuestionTitle(){
        return this.appController.goBackQuestion();
    }
    public boolean createNewSave(String fileName){
        return this.appController.createNewSave(fileName);
    }
    Set<Character> getCharactersList(){
        return this.appController.getCharactersList();
    }
    Set<Question> getQuestionsList(){
        return this.appController.getQuestionsList();
    }
    public void saveModifyBank(List<Question> questions, List<Character> characters){
        this.appController.saveModifyBank(characters, questions);
    }
    public String getLastCharacterImage(){
        return this.appController.getLastCharacterImage();
    }
}

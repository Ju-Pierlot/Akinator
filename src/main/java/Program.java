import controllers.*;
import controllers.app.AppController;
import controllers.app.IAppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import model.game.Game;
import model.repository.Repository;

public class Program extends Application {
    private Parent root;
    private IAppController appController;


    @Override
    public void start(Stage primaryStage){
        try{
            init(primaryStage);
            FXMLLoader chargerFXML = new FXMLLoader(getClass().getResource("fxml/default.fxml"));
            DefaultController defaultController = new DefaultController(this.appController, primaryStage, getClass().getResource("fxml/default.fxml"), null);
            chargerFXML.setController(defaultController);
            this.root = chargerFXML.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("HELMo - Akinator");
            primaryStage.setScene(scene);
            primaryStage.show();
            defaultController.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void init(Stage primaryStage){
        this.appController = new AppController();
        this.appController.setRepository(new Repository(getClass().getResource("save").getPath()));
        this.appController.setGame(new Game());
        Media media = new Media(getClass().getResource("song/tok.mp3").toString());
        //Media media = null;
        this.appController.setMenuController(new MenuController(this.appController, primaryStage, getClass().getResource("fxml/menu.fxml"), media));
        this.appController.setSettingsController(new SettingsController(this.appController, primaryStage, getClass().getResource("fxml/settings.fxml"), media));
        this.appController.setGameProgressController(new GameProgressController(this.appController, primaryStage, getClass().getResource("fxml/gameProgress.fxml"), media));
        this.appController.setCaseOneCharacterController(new CaseOneCharacterController(this.appController, primaryStage, getClass().getResource("fxml/caseOneCharacter.fxml"), media));
        this.appController.setSuccessEndController(new SuccessEndController(this.appController, primaryStage, getClass().getResource("fxml/successEnd.fxml"), media));
        this.appController.setFailEndController(new FailEndController(this.appController, primaryStage, getClass().getResource("fxml/failEnd.fxml"), media));
        this.appController.setAddOneCharacterController(new AddOneCharacterController(this.appController, primaryStage, getClass().getResource("fxml/addOneCharacter.fxml"), media));
        this.appController.setCaseMoreCharacterController(new CaseMoreCharacterController(this.appController, primaryStage, getClass().getResource("fxml/caseMoreCharacter.fxml"), media));
        this.appController.setModifyCharacterController(new ModifyCharacterController(this.appController, primaryStage, getClass().getResource("fxml/modifyCharacter.fxml"), media));
        this.appController.setNoCharactersLeftController(new NoCharactersLeftController(this.appController, primaryStage, getClass().getResource("fxml/noCharactersLeft.fxml"), media));
        this.appController.setCreateNewSaveController(new CreateNewSaveController(this.appController, primaryStage, getClass().getResource("fxml/createNewSave.fxml"), media));
        this.appController.setModifySaveController(new ModifySaveController(this.appController, primaryStage, getClass().getResource("fxml/modifySave.fxml"), media));
    }

}

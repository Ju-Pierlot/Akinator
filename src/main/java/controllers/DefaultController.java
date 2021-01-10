package controllers;

import controllers.app.IAppController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DefaultController extends AbstractController {
    private URL url;

    public DefaultController(IAppController appController, Stage primaryStage, URL url, Media media){
        super(appController, primaryStage, media, url);
        this.url = url;
    }
    @Override
    public URL getURL() {
        return this.url;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void start(){
        this.startApplication();
    }
}

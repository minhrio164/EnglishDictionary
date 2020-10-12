package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window ;


    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            window = primaryStage;
            Parent sampleViewScreen = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));
            primaryStage.setTitle("English Dictionary");
            Scene sampleScene = new Scene(sampleViewScreen, 351, 601);
            sampleScene.getStylesheets().add(getClass().getResource("DictionaryCss.css").toExternalForm());

            primaryStage.setScene(sampleScene);
            primaryStage.show();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

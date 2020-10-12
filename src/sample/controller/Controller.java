package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.net.URI ;

import java.io.IOException;
import java.lang.String ;




public class Controller {
    @FXML
    private TextField word_target ;
    @FXML
    private TextField typeAWord ;
    @FXML
    private Label word_explain ;
    @FXML
    private Button addButton ;

    public void DeletetypeAWord(ActionEvent event){
        String a ="a" ;
        if(a.equals(word_target.getText())==false){
            typeAWord.setText("");

        }
    }

    public void printWord_explain(ActionEvent event){
        String Word_target = word_target.getText() ;
        if(Word_target.equals("hello")){
            word_explain.setText("xin chao");
        }
        else{
            word_explain.setText("Chưa có dữ liệu");
        }

    }
    public void changeAddButton(ActionEvent event) throws IOException
    {

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader() ;
        loader.setLocation(getClass().getResource("fxml/addScreen.fxml"));
        Parent addViewScreen = loader.load() ;
        Scene scene = new Scene(addViewScreen);
        stage.setScene(scene);


    }

}

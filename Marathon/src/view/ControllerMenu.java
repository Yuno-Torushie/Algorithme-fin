package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;

public class ControllerMenu {

    @FXML
    public ImageView imageView;


    private Parent root;
    private Stage stage;
    private Scene scene;


    @FXML
    public void onJouerClick(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("gameView.fxml"));

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onRecordsClick(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("Records.fxml"));

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onQuitterClick(ActionEvent event){
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }



}

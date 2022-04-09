package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ControllerGameView;

public class Main extends Application {


    private static Main main;


    public static Main getInstance(){
        return main;
    }


    private Tirage tirage;
    public ControllerGameView controllerGameView;
    public Stage primaryStage;

    public Tirage getGameManager() {
        return tirage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        main = this;
        this.primaryStage =primaryStage;
        tirage = new Tirage();


        Parent root = FXMLLoader.load(getClass().getResource("../view/Menu.fxml"));
        primaryStage.setTitle("Marathon");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        System.out.println("Enregistreur.savedir.getPath() = " + Enregistreur.savedir.getPath());


    }


    public static void main(String[] args) {
        launch(args);
    }
}

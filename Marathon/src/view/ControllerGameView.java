package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Tirage;
import model.ImagePath;
import model.Main;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class ControllerGameView implements Initializable {

    @FXML
    private ImageView imageViewDe1;
    @FXML
    private ImageView imageViewDe2;
    @FXML
    private ImageView imageViewDe3;
    @FXML
    private ImageView imageViewDe4;

    @FXML
    private TextArea textAreaValue;

    @FXML
    private Label labelDistanceRestante;

    @FXML
    private ImageView backWardImageView;

    @FXML
    private Label timerLabel;

    @FXML
    private Label joueurNameLabel;

    @FXML
    private Button validationButton;

    private Parent root;
    private Stage stage;
    private Scene scene;

    private Main main;
    private Tirage tirage;

    private boolean dice1active;
    private boolean dice2active;
    private boolean dice3active;
    private boolean dice4active;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main = Main.getInstance();
        main.controllerGameView = this;
        tirage = main.getGameManager();
        tirage.startTimer();
        resetAffichage();


        final Label labeltimer = timerLabel;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Main.getInstance().controllerGameView.updatelabel();
                    }
                });
            }
        }, 0, 50);

    }

    public void updatelabel(){
        timerLabel.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(tirage.getTimePassed()),
                TimeUnit.MILLISECONDS.toSeconds(tirage.getTimePassed()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(tirage.getTimePassed()))
        ));
    }

    private void resetAffichage(){
        afficherlesDe();

        labelDistanceRestante.setText(tirage.getActualRemainingDistance() + "");

        textAreaValue.setText("");


        joueurNameLabel.setText(tirage.getActualJoueur().getNom());

        if(tirage.isLanceDeDisponible()){
            backWardImageView.setOpacity(1.);
        }else{
            backWardImageView.setOpacity(.5);
        }
        if(tirage.isValidationDisponible()){
            validationButton.setOpacity(1.);
        }else{
            validationButton.setOpacity(.5);
        }



    }

    public void afficherScore(){
        try {
            root = FXMLLoader.load(getClass().getResource("Records.fxml"));

            stage = (Stage)((Node)imageViewDe1
            ).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void afficherlesDe(){

        if(tirage.getDices().size() == 0){
            imageViewDe1.setImage(null);
            imageViewDe2.setImage(null);
            imageViewDe3.setImage(null);
            imageViewDe4.setImage(null);

        }

        if(tirage.getDices().size() == 1) {
            imageViewDe1.setImage(new Image(ImagePath.values()[tirage.getDices().get(0).getIndex()].path));
            imageViewDe2.setImage(null);
            imageViewDe3.setImage(null);
            imageViewDe4.setImage(null);
        }

        if(tirage.getDices().size() == 2) {
            imageViewDe1.setImage(new Image(ImagePath.values()[tirage.getDices().get(0).getIndex()].path));
            imageViewDe2.setImage(new Image(ImagePath.values()[tirage.getDices().get(1).getIndex()].path));
            imageViewDe3.setImage(null);
            imageViewDe4.setImage(null);
        }


        if(tirage.getDices().size() == 3) {
            imageViewDe1.setImage(new Image(ImagePath.values()[tirage.getDices().get(0).getIndex()].path));
            imageViewDe2.setImage(new Image(ImagePath.values()[tirage.getDices().get(1).getIndex()].path));
            imageViewDe3.setImage(new Image(ImagePath.values()[tirage.getDices().get(2).getIndex()].path));
            imageViewDe4.setImage(null);
        }

        if(tirage.getDices().size() >= 4) {
            imageViewDe1.setImage(new Image(ImagePath.values()[tirage.getDices().get(0).getIndex()].path));
            imageViewDe2.setImage(new Image(ImagePath.values()[tirage.getDices().get(1).getIndex()].path));
            imageViewDe3.setImage(new Image(ImagePath.values()[tirage.getDices().get(2).getIndex()].path));
            imageViewDe4.setImage(new Image(ImagePath.values()[tirage.getDices().get(3).getIndex()].path));
        }

    }


    @FXML
    void onLancerDeClick(MouseEvent event){

        if(tirage.isLanceDeDisponible()){

            tirage.resetGame();

            dice1active = false;
            dice2active = false;
            dice3active = false;
            dice4active = false;
        }
        resetAffichage();



    }

    @FXML
    void onDe1Click(MouseEvent event){
        if(!dice1active){
            addValueDistance(tirage.getDices().get(0).getValue(), event);
            dice1active = true;
        }
    }

    @FXML
    void onDe2Click(MouseEvent event){
        if(!dice2active){
            addValueDistance(tirage.getDices().get(1).getValue(), event);
            dice2active = true;
        }
    }

    @FXML
    void onDe3Click(MouseEvent event){
        if(!dice3active){
            addValueDistance(tirage.getDices().get(2).getValue(), event);
            dice3active = true;
        }
    }

    @FXML
    void onDe4Click(MouseEvent event){
        if(!dice4active){
            addValueDistance(tirage.getDices().get(3).getValue(), event);
            dice4active = true;

        }

    }


    private void addValueDistance(int dictance, MouseEvent event){
        ImageView imageView = (ImageView) event.getSource();


        Color targetColor = Color.BLUEVIOLET;
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setSaturation(targetColor.getSaturation());
        colorAdjust.setHue(targetColor.getHue());
        colorAdjust.setBrightness(targetColor.getBrightness());



        imageView.setEffect(colorAdjust);
        if(textAreaValue.getText() != null){

            textAreaValue.setText(
                    textAreaValue.getText() + dictance
            );
        }else{
            textAreaValue.setText(dictance + "");

        }
    }


    @FXML
    void onValiderDistance(ActionEvent event){

        if(tirage.isValidationDisponible()){
            tirage.avancerUnJoueur(Integer.parseInt(textAreaValue.getText()));

        }
        resetAffichage();

    }

    @FXML
    void onDeEnter(MouseEvent event){
        ImageView imageView = (ImageView) event.getSource();

        Color targetColor = Color.GREEN;
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setSaturation(targetColor.getSaturation());
        colorAdjust.setHue(targetColor.getHue());
        colorAdjust.setBrightness(targetColor.getBrightness());

        if(imageView == imageViewDe1 && !dice1active){
            imageView.setEffect(colorAdjust);
        }
        if(imageView == imageViewDe2 && !dice2active){
            imageView.setEffect(colorAdjust);
        }
        if(imageView == imageViewDe3 && !dice3active){
            imageView.setEffect(colorAdjust);
        }
        if(imageView == imageViewDe4 && !dice4active){
            imageView.setEffect(colorAdjust);
        }


    }
    @FXML
    void onDeExit(MouseEvent event){
        ImageView imageView = (ImageView) event.getSource();

        if(imageView == imageViewDe1 && !dice1active){
            imageView.setEffect(null);
        }
        if(imageView == imageViewDe2 && !dice2active){
            imageView.setEffect(null);
        }
        if(imageView == imageViewDe3 && !dice3active){
            imageView.setEffect(null);
        }
        if(imageView == imageViewDe4 && !dice4active){
            imageView.setEffect(null);
        }
    }


    @FXML
    void onPasserClick(){
        tirage.passerAuJoueurSuivant();
        resetAffichage();
        imageViewDe1.setEffect(null);
        imageViewDe2.setEffect(null);
        imageViewDe3.setEffect(null);
        imageViewDe4.setEffect(null);

    }



    @FXML
    void onBackWarClick(MouseEvent event){
        textAreaValue.setText("");
        dice1active = false;
        dice2active = false;
        dice3active = false;
        dice4active = false;

    }


}

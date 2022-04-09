package model;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Tirage implements Serializable {


    //attribut
    private List<Dice> dices;

    private Record joueur1;
    private Record joueur2;


    private Timer timer;
    private TimerTask timerTask;

    private long timeStart;
    private Record actualJoueur;


    private boolean lanceDeDisponible;

    public boolean isLanceDeDisponible() {
        return lanceDeDisponible;
    }

    private boolean validationDisponible;

    public boolean isValidationDisponible() {
        return validationDisponible;
    }

    //getter setter
    public long getTimePassed(){
        return System.currentTimeMillis() - timeStart + actualJoueur.timePassed;
    }

    public int getActualRemainingDistance() {
        return actualJoueur.distanceRestante;
    }

    public List<Dice> getDices() {
        return dices;
    }

    public Record getJoueur1() {
        return joueur1;
    }

    public Record getJoueur2() {
        return joueur2;
    }

    public Record getActualJoueur() {
        return actualJoueur;
    }

    //constructeur
    public Tirage(){
        dices = new ArrayList<>();
        joueur1 = new Record("joueur1");
        joueur2 = new Record("joueur2");
        actualJoueur = joueur1;

        validationDisponible = false;
        lanceDeDisponible = true;

        windowNewDice(joueur1);
        windowNewDice(joueur2);
    }


    //méthode public
    public void startTimer(){
        timeStart = System.currentTimeMillis();
    }

    public void  lancerLesDe(){
        for (Dice de: dices    ) {
            de.lancerLeDe();
        }
        validationDisponible = true;
        lanceDeDisponible = false;
    }

    public void  avancerUnJoueur(int distance){
        actualJoueur.distanceRestante -= distance;
        if(actualJoueur.distanceRestante <= 0){
            actualJoueur.haveFinish = true;
        }
        validationDisponible = false;

    }

    public void resetGame(){
        dices.clear();

        for (int i = 0; i <= getNbdiceToDisplay() && i < 4; i++) {
            dices.add(new Dice());
        }
        lancerLesDe();
    }


    public int getNbdiceToDisplay(){
        return ((Integer)actualJoueur.distanceRestante).toString().length() - 1;
    }


    public void passerAuJoueurSuivant(){
        if(joueur1.haveFinish || joueur2.haveFinish){
            if(joueur1.haveFinish && joueur2.haveFinish){
                fin();
            }else  if(joueur1.haveFinish){
                actualJoueur = joueur2;
            }else{
                actualJoueur = joueur1;
            }
            System.out.println("un des joueur a termine");
        }else{

            actualJoueur.timePassed += System.currentTimeMillis() - timeStart;
            timeStart = System.currentTimeMillis();
            if(actualJoueur == joueur1){
                actualJoueur = joueur2;
            }else{
                actualJoueur = joueur1;
            }
        }
        dices.clear();
        lanceDeDisponible = true;
        validationDisponible = false;
    }


    private void fin(){

        Enregistreur enregistreur = new Enregistreur();

        ArrayList<Record> records = new ArrayList<Record>() {{
            add(joueur1);
            add(joueur2);
        }};
        enregistreur.enregistrerScore(records);

        Main.getInstance().controllerGameView.afficherScore();

    }

    //methode qui affiche une fenêtre pour choisir le type du de
    private void windowNewDice(Record joueur){
        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");



        Label secondLabel = new Label(joueur.getNom());

        // TextField
        TextField textField = new TextField();


        Button button = new Button("valider");
        button.setOnAction(event -> {
            joueur.setNom(textField.getText());
            newWindow.close();
        });


        AnchorPane secondaryLayout = new AnchorPane();
        secondaryLayout.getChildren().addAll(secondLabel, textField, button);


        AnchorPane.setLeftAnchor(secondLabel, 50d);
        AnchorPane.setRightAnchor(secondLabel, 50d);
        AnchorPane.setTopAnchor(textField, 50d);
        AnchorPane.setTopAnchor(button, 80d);
        AnchorPane.setLeftAnchor(textField, 10d);
        AnchorPane.setRightAnchor(textField, 10d);
        AnchorPane.setRightAnchor(button, 10d);
        AnchorPane.setLeftAnchor(button, 10d);
        Scene secondScene = new Scene(secondaryLayout, 230, 120);

        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        newWindow.setX(Main.getInstance().primaryStage.getX() +400 );
        newWindow.setY(Main.getInstance().primaryStage.getY() + 200);

        newWindow.show();
    }
}

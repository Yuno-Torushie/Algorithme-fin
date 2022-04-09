package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Enregistreur;
import model.Record;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ControllerRecords implements Initializable {

    @FXML
    private ListView<String> listViewScore;


    private Parent root;
    private Stage stage;
    private Scene scene;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //todo chargé dans la liste view les record
        Enregistreur enregistreur = new Enregistreur();
        List<Record> records = enregistreur.chargerScore();

        Collections.sort(records);

        ObservableList<String> listscore  = FXCollections.observableArrayList();

        for (Record record : records
             ) {


            String i = String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(record.timePassed),
                    TimeUnit.MILLISECONDS.toSeconds(record.timePassed) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(record.timePassed))
            );
            listscore.add(record.getNom() + " : " + i);


        }



        listViewScore.setItems(listscore);

    }

    @FXML
    public void onNextClick(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package model;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Enregistreur implements Serializable {


    public static final File savedir = new File(new File(System.getProperty("user.home")), ".marathon");



    public void enregistrerScore(List<Record> recordToSave){
        try {
            if(!savedir.exists())
                Files.createDirectory(savedir.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Records records = new Records();
        records.records = recordToSave;


        if(chargerScore() != null)
            records.records.addAll(chargerScore());

        ObjectOutputStream oos = null;
        final FileOutputStream fichier;
        try {
            fichier = new FileOutputStream(savedir + "/RecordsMarathon.csv" );
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(records);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Record> chargerScore() {
        // ouverture d'un flux sur un fichier
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(savedir + "/RecordsMarathon.csv"));

            // désérialization de l'objet
            Records records = (Records) ois.readObject();
            return  records.records;


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;

    }

    private class Records implements Serializable{
        public List<Record> records;
    }
}



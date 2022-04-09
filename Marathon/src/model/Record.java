package model;

import java.io.Serializable;

public class Record implements Serializable , Comparable {

    private static final int DISTANCEDEFAULT = 42195;


    private String nom;

    public int distanceRestante;

    public long timePassed;

    public boolean haveFinish;



    public Record(String nom){
        this.nom = nom;
        haveFinish = false;
        timePassed = 0;
        distanceRestante = DISTANCEDEFAULT;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Record){
            return (int) (timePassed - ((Record) o).timePassed);
        }
        return 0;
    }
}

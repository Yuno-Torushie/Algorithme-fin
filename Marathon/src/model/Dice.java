package model;

import java.io.Serializable;

public class Dice implements Serializable {

    private int value;

    public int getIndex() {
        return value;
    }

    public int getValue() {
        return value + 1;
    }




    public void  lancerLeDe(){
         value = (int) (Math.random() * 6);
    }



}

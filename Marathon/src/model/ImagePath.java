package model;

public enum ImagePath {

    UN("ressources/un.png"),
    DEUX("ressources/deux.png"),
    TROIS("ressources/trois.png"),
    QUATRE("ressources/quatre.png"),
    CINQ("ressources/cinq.png"),
    SIX("ressources/six.png");


    public final String path;


    private ImagePath(String path){
        this.path = path;
    }


}

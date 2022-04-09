package file;

public class FileParChainage{

    public int valeur;
    public Noeud tete, queu;

    public boolean fileVide() {
        if(valeur == 0) {
            return true;
        }
        else{
            return false;

        }
    }
    public boolean filePleine(){
        return false;
    }
    //Obtenir la longueur d'une file
    public int longueur() {
        return valeur;
    }

    //Le premier element de la file
    public Object premier() {
        return tete;
    }

    // Enfiler une valeur au sommet d'une file
    public void enfiler(Object element) {
        Noeud v;
        v=new Noeud();
        v.valeur=element;
        v.suivant=null;

        if (fileVide()==true) {
            tete=v;
        }
        else {
            queu.suivant=v;
        }
        queu=v;
        valeur++;
    }

    // Défiler une valeur au sommet d'une file
    public Object defiler() throws FileVideException
    {
        Object v;
        v=new Noeud();
        if(fileVide()==true) {
            throw new FileVideException();
        }
        else {
            v=tete.valeur;
            valeur--;
            tete = tete.suivant;
            return v;
        }
    }
}
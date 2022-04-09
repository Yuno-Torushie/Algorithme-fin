package TP1;

public class Histoire {

	public static void main(String[] args) {
       
		Humain lepremier = new Humain("Patrick");//Humain
        Humain lesecond = new Brigand("Gilbert");//Brigand
        Humain letroisieme = new Barman("Tartempion");//Barman
        Humain lequatrieme = new Dame("Joséphine");//Dame
        Humain lecinquieme = new Shérif("Michel");//Shérif
        Humain lesixieme = new Cowboy("Ace");//Cowboy

        lepremier.parler("Salut !");
        lesecond.parler("Bonchour, la compagnie !");
        letroisieme.parler("Coucou !");
        lequatrieme.parler("Salut, mon chou!");
        lecinquieme.parler("Yo !");
        lesixieme.parler("Sa roule ma poule?");
        
        System.out.println(lepremier.quelEstTonNom());
        System.out.println(lesecond.quelEstTonNom());
        System.out.println(letroisieme.quelEstTonNom());
        System.out.println(lequatrieme.quelEstTonNom());
        System.out.println(lecinquieme.quelEstTonNom());
        System.out.println(lesixieme.quelEstTonNom());
        
        System.out.println(lepremier.getBoissonFavorite());
        System.out.println(lesecond.getBoissonFavorite());
        System.out.println(letroisieme.getBoissonFavorite());
        System.out.println(lequatrieme.getBoissonFavorite());
        System.out.println(lecinquieme.getBoissonFavorite());
        System.out.println(lesixieme.getBoissonFavorite());
        
        lepremier.sePresenter();
        lesecond.sePresenter();
        letroisieme.sePresenter();
        lequatrieme.sePresenter();
        lecinquieme.sePresenter();
        lesixieme.sePresenter();
    }
}

public class MysteryNumber {

	public static int DEFAULT_MAX_VALUE = 100 ;
	public static final int ABORT_VALUE = Integer.MAX_VALUE ;
	private int max_value;
	
	public MysteryNumber(){
		this(MysteryNumber.DEFAULT_MAX_VALUE);
	}

	public MysteryNumber(int max_value){
		super();
		this.max_value = max_value;
	}
	
	public int play(){
		
	    int score=0;
	    int value=0;
	    int mystery = new Double(this.max_value * Math.random() +1).intValue();
	    
	    System.out.println("Trouvez le nombre myst?re (entre 1 et " + this.max_value + ", 0 pour abandon) : ");
	    
	    while (value != mystery) {
		    /* Le joueur tente sa chance */
		    System.out.println("Entrez un nombre (#" + score + ") : ");
		    value=Lire.i();
		    /* abandon ? */
		    if (value == 0)
		    	return MysteryNumber.ABORT_VALUE;
		    /* valide son essai, ou oriente sa recherche */
		    else if (value > mystery)
		    	  System.out.println("Trop grand");
		    else if (value < mystery)
		    	  System.out.println("Trop petit");
		    score++;
	    }
	    
	    /* Get it ! */
	    System.out.println("Bravo, vous avez gagne en " + score + " coups");
	    return score;
	}
	public static void main(String[] args) {
		/* Unit tests */
		MysteryNumber game = new MysteryNumber();//rentrer le nombre max
		game.play();//renvoie le score
	}
}

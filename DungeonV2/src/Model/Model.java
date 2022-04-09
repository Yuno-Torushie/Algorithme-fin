package Model;

public class Model {
	  
	private Dungeon theDungeon;
	  private Player thePlayer;

	  public Model() {
	    theDungeon = new Dungeon();
	    thePlayer = new Player();
	    thePlayer.setCurrentLocation(theDungeon.getStartingRoom());
	  }

	  public Player getPlayer() {
	    return thePlayer;
	  }

}

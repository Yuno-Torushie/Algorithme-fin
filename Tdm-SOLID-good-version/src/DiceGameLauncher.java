import dicegame.DiceGame;
import dicegame.IDiceGame;

public class DiceGameLauncher {

	public static void main(String[] args) {
		IDiceGame game = new DiceGame(); 
		game.start();
	}

}

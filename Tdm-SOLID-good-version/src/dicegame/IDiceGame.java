package dicegame;

public interface IDiceGame {
	public void start();
	public void playOneRound();
	public int getRandomDiceValue();
	public void displayEntryText();
	public void displayPlayAgainText();
	public void displaySuccessText();
}

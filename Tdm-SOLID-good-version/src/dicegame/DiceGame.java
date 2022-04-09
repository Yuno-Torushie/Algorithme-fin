package dicegame;

public class DiceGame implements IDiceGame{

	private DiceWith6Faces dice;
	private KeyboardInput input;
	
	public DiceGame() {
		super();
		input = new KeyboardInput();
		dice = new  DiceWith6Faces();
		// change next line depending on the dice
		// dice = new  DiceWith8Faces();
	}

	@Override
	public void start() {
		do {
			playOneRound();
		} while (input.readChar() == 'y');
	}

	@Override
	public void playOneRound() {
		displayEntryText();
		int userChoice =input.readInt();
		int diceRollValue = getRandomDiceValue();
		displayDiceValue(diceRollValue);
		if (userChoice == diceRollValue)
			displaySuccessText();
		displayPlayAgainText();
	}

	private void displayDiceValue(int diceRollValue) {
		System.out.println("Dice roll..");
		System.out.println("The value is " + diceRollValue);
	}

	@Override
	public int getRandomDiceValue() {
		if (dice instanceof DiceWith6Faces)
			return dice.getRandomValue();
		else 
			return ((DiceWith8Faces)dice).getRandomValueFrom1To8();
	}

	@Override
	public void displayEntryText() {
		System.out.println("Guess the dice value on next roll : ");
	}

	@Override
	public void displayPlayAgainText() {
		System.out.println("play again ?");
	}

	@Override
	public void displaySuccessText() {
		System.out.println("Well done!");
	}

}

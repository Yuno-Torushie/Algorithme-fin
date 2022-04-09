package dicegame;

public class DiceWith8Faces extends DiceWith6Faces {

	@Override
	public int getRandomValue() {
		return getRandomValueFrom1To8();
	}
	
	public int getRandomValueFrom1To8() {
		return ((int)Math.random()*8) + 1;
	}

}

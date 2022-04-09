package src.games;

public class Score {

	String who ;
	String when ;
	int value;
	
	// Constructeur par défaut, sans argument
	public Score() {
		super();
	}

	/**
	 * @param who
	 * @param when
	 * @param value
	 */
	public Score( int value, String who, String when) {
		super();
		this.who = who;
		this.when = when;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getWhen() {
		return when;
	}

	public String getWho() {
		return who;
	}

	@Override
	public String toString() {
		return "Score{" +
				"who='" + who + '\'' +
				", when='" + when + '\'' +
				", value=" + value +
				'}';
	}
}
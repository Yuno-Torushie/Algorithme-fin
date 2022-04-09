package exo2.test_jackson;

public class Glass {
	
	public String color;
	private int counter = 0;

	public Glass(String color) {
		this.color = color;
	}

	// Jackson : needs default constructor
	public Glass() {
	}

	public void drink() {
		System.out.println("🍷🍷🍷 - glou glou, from color " + this.color + " #" + this.counter + " !");
		this.counter++;
	}

	// Jackson : needs Getter to serialize private fields
	public int getCounter () { return this.counter; }
}

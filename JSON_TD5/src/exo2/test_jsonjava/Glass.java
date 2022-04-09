package exo2.test_jsonjava;

// JSON-java : works only with public Class
public class Glass {

	public String color;
	private int counter = 0;

	public Glass(String color) {
		this.color = color;
	}

	// JSON-java : constructor with all members, only for test
	public Glass(String color, int counter) {
		this.color = color;
		this.counter = counter;
	}

	public void drink() {
		System.out.println("🍷🍷🍷 - glou glou, from color " + this.color + " #" + this.counter + " !");
		this.counter++;
	}

	//JSON-Java : needs Getter to serialize all fields
	public String getColor () { return this.color; }
	public int getCounter () { return this.counter; }
}

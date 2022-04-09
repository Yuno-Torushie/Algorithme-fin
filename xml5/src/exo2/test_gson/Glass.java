package exo2.test_gson;

public class Glass {
	
	public String color;
	private int counter = 0;

	public Glass(String color) {
		this.color = color;
	}

	public void drink() {
		System.out.println("🍷🍷🍷 - glou glou, from color " + this.color + " #" + this.counter + " !");
		this.counter++;
	}

}

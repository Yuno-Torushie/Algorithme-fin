package exo1;


public class Coffee{
	private String id ;
	public String name ;
	public double price ;
	
	public Coffee() {
	}
	
	public Coffee(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return "Coffee #" + this.id + " : " + this.name + " => " + this.price + " �";
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}


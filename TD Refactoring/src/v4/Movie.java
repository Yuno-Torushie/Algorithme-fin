package v4;

public class Movie {
	
	//CHILDRENS = 2; 
	//REGULAR = 0; 
	//NEW_RELEASE = 1;
	
	private String title; 
	private Price price;
	
	public Movie(String title, Price priceCode) { 
		this.title = title;
		this.price = priceCode;
	}
	
	public void setPriceCode(Price priceCode) {
		this.price = priceCode;
	}

	public String getTitle (){ 
		return title;
	}

	public double getCharge(int daysRented) {
        return price.getChargeFor(daysRented);
	}
	
	int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
}
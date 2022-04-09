package V3;

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
	
	public PriceEnum getPriceCode() { 
		return price.getPriceCode();
	}
	
	public void setPriceCode(Price priceCode) {
		this.price = priceCode;
	}

	public String getTitle (){ 
		return title;
	}

	public double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (getPriceCode()) {
        case REGULAR: 
            thisAmount += 2;
            if (daysRented > 2)
                thisAmount += (daysRented - 2) * 1.5;
            break;
        case NEW_RELEASE:
            thisAmount += daysRented * 3; 
            break;
        case CHILDRENS:
            thisAmount += 1.5;
            if (daysRented > 3)
                thisAmount += (daysRented - 3) * 1.5; 
            break;
        }
        return thisAmount;
	}
	
	int getFrequentRenterPoints(int daysRented) {
		if ((getPriceCode() == PriceEnum.NEW_RELEASE) && daysRented > 1){
			return 2;
		}
		return 1;
	}
}
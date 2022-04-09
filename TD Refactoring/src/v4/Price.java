package v4;

public interface Price {
	
	public abstract double getChargeFor(int daysRented);
	
	public default int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
	
}

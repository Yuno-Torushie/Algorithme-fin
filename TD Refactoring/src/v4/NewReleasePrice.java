package v4;

public class NewReleasePrice implements Price{
	
	@Override
	public double getChargeFor(int daysRented) {
        double thisAmount = 0;
        thisAmount += daysRented * 3;
        return thisAmount;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		if(daysRented > 1) {
			return 2;
		}
		return 1;
	}
	
}

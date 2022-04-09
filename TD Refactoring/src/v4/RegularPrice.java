package v4;

public class RegularPrice implements Price {
	
	@Override
	public double getChargeFor(int daysRented) {
        double thisAmount = 0;
        thisAmount += 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
	}

}

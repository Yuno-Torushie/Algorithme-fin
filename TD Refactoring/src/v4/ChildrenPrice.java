package v4;

public class ChildrenPrice implements Price{

	@Override
	public double getChargeFor(int daysRented) {
        double thisAmount = 0;
        thisAmount += 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
	}
	
}

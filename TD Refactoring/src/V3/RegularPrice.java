package V3;

public class RegularPrice implements Price {
	
	@Override
	public PriceEnum getPriceCode() {
		return PriceEnum.REGULAR;
	}

}

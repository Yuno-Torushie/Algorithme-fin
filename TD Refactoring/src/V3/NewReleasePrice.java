package V3;

public class NewReleasePrice implements Price{
	
	@Override
	public PriceEnum getPriceCode() {
		return PriceEnum.NEW_RELEASE;
	}

}

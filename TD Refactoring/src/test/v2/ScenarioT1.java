package v1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScenarioT1 {

	@Test
	public void testStatement() {
		Customer paul = new Customer("Paul");
		
		paul.addRental(new Rental(new Movie("Monty Python et le sacre graal",Movie.REGULAR),3));
		paul.addRental(new Rental(new Movie("La cite de la peur",Movie.REGULAR),2));
		paul.addRental(new Rental(new Movie("Han Solo ",Movie.NEW_RELEASE),2));
		paul.addRental(new Rental(new Movie("Moi, moche et mechant",Movie.CHILDRENS),4));
		paul.addRental(new Rental(new Movie("Wallace and Gromit",Movie.CHILDRENS),6));
		
		assertEquals(20.5, paul.getTotalCharge(), 0.);
		assertEquals(6, paul.getTotalFrequentRenterPoints());
	}

}

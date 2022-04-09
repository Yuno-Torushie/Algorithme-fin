package v4;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import V3.Rental;

public class Customer extends TextStatement{

	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer (String name){ 
		this.name = name;
	}
	
	public List<Rental> getRentals() {
		return rentals;
	}	

	public void addRental(Rental aRental) { 
		rentals.add(aRental);
	}

	public String getName (){
		return name; 
	}
	
	public String statement() {
		return new TextStatement()
	}
	
	public String htmlStatement() {
		StringBuilder result = new StringBuilder("<H1>Rental Record for <EM>"
				+ getName() + "</EM></H1><P>\n");

		for(Rental each : rentals) {
			result.append("\t"+ each.getMovie().getTitle() 
					+ "\t" + each.getCharge() + "<BR>\n");
			
		}
		
		result.append("<P>Amount owed is <EM>" + getTotalCharge() + "</EM></P>\n");
		result.append("You earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points </P>");
		return result.toString();
	}

	int getTotalFrequentRenterPoints() {
		int result = 0;
		
		for(Rental each : rentals) {
			result += each.getFrequentRenterPoints(each);
		}
		
		return result;
	}

	double getTotalCharge() {
		double result = 0;
		
		for(Rental each : rentals) {
			result += each.getCharge();
		}
		
		return result;
	}

}
package v4;

public class TextStatement extends Statement{
	
    @Override
    public String headerString(Customer aCustomer) {
        return "Rental Record For " + aCustomer.getName() + "\n";
    }

    @Override
    public String footerString(Customer aCustomer) {
        return "Amount owed is " + aCustomer.getTotalCharge() + "\n" 
                        + "You earned " + aCustomer.getTotalFrequentRenterPoints() 
                        + " frequent renter points.";
    }

    @Override
    public String eachRentalString(Rental aRental) {
        return "\t" + aRental.getMovie().getTitle() + "\t" + aRental.getCharge() + "\n";
    }

}

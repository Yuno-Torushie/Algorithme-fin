package v4;

public class htmlTextStatement extends Statement{

    @Override
    public String headerString(Customer aCustomer) {
        return "<h1>Rental Record For <em>" + aCustomer.getName() + "</em></h1><br/>\n";
    }

    @Override
    public String footerString(Customer aCustomer) {
        return "<p>You owe <em>" + aCustomer.getTotalCharge() + "</em>\n" 
                        + "You earned <em>" + aCustomer.getTotalFrequentRenterPoints() 
                        + "</em> frequent renter points.</p>";
    }

    @Override
    public String eachRentalString(Rental aRental) {
        return aRental.getMovie().getTitle() + " : " + aRental.getCharge() + "<br/>";
    }

}

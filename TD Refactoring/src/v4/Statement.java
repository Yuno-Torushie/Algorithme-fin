package v4;

import java.util.Iterator;

public abstract class Statement {
	
    public abstract String headerString(Customer aCustomer);
    public abstract String footerString(Customer aCustomer);
    public abstract String eachRentalString(Rental aRental);
    
    public final String value(Customer aCustomer) {
        Iterator<Rental> rentals = aCustomer.getRentals().iterator();
        
        StringBuilder result = new StringBuilder(headerString(aCustomer));
        while(rentals.hasNext()) {
            Rental each = rentals.next();
            result.append(eachRentalString(each));
        }
        
        return result.toString();
    }

}

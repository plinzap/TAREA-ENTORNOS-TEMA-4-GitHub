import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer (String name) {
        _name = name;
    }

    public void addRental (Rental arg) {
        _rentals.addElement(arg);
    }

    public String statement () {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           double thisAmount = each.getCharge();
           frequentRenterPoints+=each.getFrequentRenterPoints();
           // show figures for this rental
           result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
           totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
    
    public String getName() {
        return _name;
    }
}

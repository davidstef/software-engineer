package invoice;

import invoice.Invoice;

import java.util.Date;

public class ComplexInvoice extends Invoice {
    private final Date dateCreated;
    public ComplexInvoice(int number, Date dateCreated) {
        super(number);
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getNumber()) + " " + dateCreated;
    }
}

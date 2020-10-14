package good;

import invoice.Invoice;
import invoicePrinter.GoodInvoicePrinter;
import invoicePrinter.GoodInvoicePrinter_I;

public class GoodPrintingService implements GoodPrintingService_I {

    private GoodInvoicePrinter_I invoicePrinter;

    public GoodPrintingService() {
        this.invoicePrinter = new GoodInvoicePrinter();
    }

    @Override
    public void print(Invoice invoice) {
        invoicePrinter.print(invoice);
    }

}
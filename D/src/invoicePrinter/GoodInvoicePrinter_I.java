package invoicePrinter;

import invoice.ComplexInvoice;
import invoice.Invoice;

public interface GoodInvoicePrinter_I {
    void print(Invoice invoice);
    void printComplexInvoice(ComplexInvoice complexInvoice);
}

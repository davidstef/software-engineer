import good.GoodInvoicePrinter;
import good.GoodInvoicePrinter_I;
import good.SomeOtherGoodInvoicePrinter;
import good.SomeOtherGoodInvoicePrinter_I;
import invoice.ComplexInvoice;
import invoice.Invoice;

import java.util.Date;

public class IMain {
    public static void main(String[] args) {
        testGoodI();
    }

    private static void testGoodI() {
        Invoice invoice = new Invoice(-132523);
        ComplexInvoice complexInvoice = new ComplexInvoice(21439, new Date());

        GoodInvoicePrinter_I goodInvoicePrinter = new GoodInvoicePrinter();
        goodInvoicePrinter.print(invoice);
        goodInvoicePrinter.printComplexInvoice(complexInvoice);

        SomeOtherGoodInvoicePrinter_I someOtherGoodInvoicePrinter = new SomeOtherGoodInvoicePrinter();
        someOtherGoodInvoicePrinter.someOtherPrintMethod(invoice);
    }
}

import good.GoodPrintingService;
import good.GoodPrintingService_I;
import invoice.Invoice;

public class DMain {
    public static void main(String[] args) {
        testGoodD();
    }

    private static void testGoodD() {
        Invoice invoice = new Invoice(665);

        GoodPrintingService_I goodPrintingService = new GoodPrintingService();
        goodPrintingService.print(invoice);

    }
}

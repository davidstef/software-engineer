import good.GoodEmployee;
import good.InfoEmployee;

public class SMain {

    public static void main(String[] args) {
        testBadS();
    }

    private static void testBadS() {
        GoodEmployee employee = new GoodEmployee("1", "BadEmployee", 5);
        InfoEmployee infos = new InfoEmployee(employee);
        infos.calculatePay();
        infos.reportHours();
        infos.save();
    }
}

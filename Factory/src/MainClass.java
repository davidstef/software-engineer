
public class MainClass {

    public static void main(String args[]) {
        ShipLogistics shipLogistics = new ShipLogistics();
        RoadLogistics roadLogistics = new RoadLogistics();
        Logistics logistic1=new RoadLogistics();
        Logistics logistic2=new ShipLogistics();
        Transport t= logistic1.createTransport();
        Transport t2= logistic2.createTransport();
        t.deliver("type 1");
        t2.deliver("type 2");
    }
}

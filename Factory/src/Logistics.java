
public interface Logistics {

    default Transport planDelivery() {
        Transport transport = createTransport();
        return transport;
    }

    public Transport createTransport();

}

import java.io.IOException;

public class Listener implements EventListener {

    @Override
    public void update(String data) {
        System.out.println("Current element have been updated with the new value: " + data);
    }

    @Override
    public void close() throws IOException {

    }
}

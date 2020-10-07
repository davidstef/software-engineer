import java.io.IOException;

public interface EventListener {
    public void update(String data) throws IOException;
    public void close() throws IOException;
}

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EventManager {
    private HashMap<String, EventListener> listeners = new HashMap<String, EventListener>();

    public void subscribe(String eventType, EventListener listener) {
        listeners.put(eventType, listener);
    }

    public void unsubscribe(String eventType, LoggingListener listener) {
        listeners.remove(eventType, listener);
    }

    public void notify(String eventType, String data) throws IOException {
        for (Map.Entry<String, EventListener> listener : listeners.entrySet()) {
            listener.getValue().update(data);
        }
    }
    public void notify(String message) throws IOException {
        System.out.println(message);
        for (Map.Entry<String, EventListener> listener : listeners.entrySet()) {
            listener.getValue().close();
        }
    }

}

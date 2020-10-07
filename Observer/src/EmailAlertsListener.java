import java.io.IOException;

public class EmailAlertsListener implements EventListener {
    private String email;
    private String message;

    EmailAlertsListener(String email, String message) {
        this.email = email;
        this.message = message;
    }

    @Override
    public void update(String filename) throws IOException {
        System.out.println("The email adress is: " + email +
                ", the message is: " + message + " and they " +
                "can be found at: " + filename);
    }

    @Override
    public void close() throws IOException {
    }
}

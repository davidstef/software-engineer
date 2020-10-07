import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EventListener;

public class Application {
    public void config() throws IOException {
        Editor editor = new Editor();
        LoggingListener logger = new LoggingListener(
                "C:\\IntelijProjects\\Observer\\observer.txt",
                "Someone has opened the file: %s"
        );
        editor.getEvents().subscribe("open", logger);

        EmailAlertsListener emailAlerts = new EmailAlertsListener(
                "admin@example.com",
                "Someone has canged the file: %s");
        editor.getEvents().subscribe("save", emailAlerts);
        editor.openFile("C:\\IntelijProjects\\Observer\\data.txt");
        editor.saveFile("This file contains saved data!");
        editor.closeFile();
    }

    public static void main(String ...args) throws IOException {
        Application app = new Application();
        app.config();


    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggingListener implements EventListener {
    FileWriter log;
    String message;

    LoggingListener(String logFileName, String message) throws IOException {
        this.log = new FileWriter(logFileName);
        this.message = message;
    }

    @Override
    public void update(String fileName) throws IOException {
        log.write(fileName + "\n");
        System.out.println("The file can be found at: " + fileName);

    }

    @Override
    public void close() throws IOException {
        log.close();
    }
}

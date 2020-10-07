import java.io.FileWriter;
import java.io.IOException;

public class Editor {
    private EventManager events;
    private FileWriter file;
    private String fileName;

    public EventManager getEvents() {
        return events;
    }

    Editor() {
        events = new EventManager();
    }

    public void openFile(String path) throws IOException {
        this.file = new FileWriter(path);
        this.fileName = path.substring(path.lastIndexOf("\\")+1,path.length());
        events.notify("open", fileName);
    }

    public void saveFile(String data) throws IOException {
        file.write(data + "\n");
        events.notify("save", fileName);

    }

    public void closeFile() throws IOException {
        file.close();
        events.notify("Close all files opened");

    }
}

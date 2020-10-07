import java.util.ArrayList;

public class CompoundGraphic implements Graphic {
    private ArrayList<Graphic> children = new ArrayList<Graphic>();

    public ArrayList<Graphic> getChildren() {
        return children;
    }

    public void add(Graphic child) {
        children.add(child);
    }

    public void remove(Graphic child) {
        children.remove(child);
    }

    @Override
    public void move(int x, int y) {
        for (Graphic child : children) {
            child.move(x, y);
        }
    }

    @Override
    public void draw() {
        System.out.println("Draw the next component Graphic: ");
        for (Graphic child : children) {
            child.draw();
        }
    }
}

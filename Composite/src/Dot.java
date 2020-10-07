
public class Dot implements Graphic {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Point draw at coordinates (" + x + ", " + y + ")");
    }
}

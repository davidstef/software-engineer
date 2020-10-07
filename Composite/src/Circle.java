
public class Circle extends Dot {
    double radius;

    Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public void draw() {
        System.out.println("The circle with center in (" + x + ", " + y + ") and radius: " + radius);
    }
}

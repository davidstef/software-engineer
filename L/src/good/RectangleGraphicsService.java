package good;

public class RectangleGraphicsService {
    public void checkForArea(Rectangle rectangle) {
        int height = 20;
        int width = 5;
        rectangle.setHeight(height);
        rectangle.setWidth(width);
        verify(rectangle, width, height);

    }

    private void verify(Rectangle rectangle, int width, int height) {
        if (rectangle.getArea() == (width * height)) {
            System.out.println("Great rectangle you got there!");
        } else {
            System.out.println("Well, not a rectangle.");
        }
    }

}

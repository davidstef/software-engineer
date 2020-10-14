import good.Rectangle;
import good.RectangleGraphicsService;
import good.Square;
import good.SquareGraphicsService;

public class LMain {
    public static void main(String[] args) {
        testGoodL();
    }

    private static void testGoodL() {
        Rectangle rectangle = new Rectangle(20, 30);
        Square square = new Square(25);
        SquareGraphicsService squareGraphics = new SquareGraphicsService();
        RectangleGraphicsService rectangleGraphics = new RectangleGraphicsService();


        squareGraphics.checkForArea(square);
        rectangleGraphics.checkForArea(rectangle);
    }
}

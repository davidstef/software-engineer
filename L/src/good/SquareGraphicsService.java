package good;

public class SquareGraphicsService {
    private void verify(Square square, int side) {
        if (square.getArea() == (side * side)) {
            System.out.println("Great square you got there!");
        } else {
            System.out.println("Well, not a square.");
        }
    }

    public void checkForArea(Square square) {
        int side = 10;
        square.setSide(side);
        verify(square, side);
    }
}

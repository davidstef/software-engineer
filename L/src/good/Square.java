package good;

public class Square {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getArea() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return "I am a square";
    }
}

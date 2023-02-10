package src.collectionClasses;

public class Coordinates {
    private int x;
    private Long y;

    public Coordinates(int x, Long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "; " + y;
    }
}

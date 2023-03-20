package src.collections;

/**
 * Dragon's coordinates
 */
public class Coordinates {
    private int x;
    private Long y;

    public Coordinates(int x, Long y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return two coordinates separated by a semicolon
     */
    @Override
    public String toString() {
        return x + "; " + y;
    }

    /**
     *
     * @return sum of x and y
     */
    public Long sum() {
        return x + y;
    }

    public int getX() {
        return x;
    }

    public Long getY() {
        return y;
    }
}

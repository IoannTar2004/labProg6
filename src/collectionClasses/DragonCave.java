package src.collectionClasses;

public class DragonCave {
    private double death;

    public DragonCave(double death) {
        this.death = death;
    }

    @Override
    public String toString() {
        return "" + death;
    }
}

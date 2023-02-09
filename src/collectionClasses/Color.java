package src.collectionClasses;

public enum Color {
    BLACK("Черный"), BLUE("Синий"), YELLOW("Жёлтый");

    private String color;
    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

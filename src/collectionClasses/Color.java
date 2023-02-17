package src.collectionClasses;

public enum Color {
    BLACK("Чёрный"), BLUE("Синий"), YELLOW("Жёлтый");

    private String color;
    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static Color getEnumColor(String color) {
        if (color.matches("\\s*Чёрный\\s*")) {return BLACK;}
        else if (color.matches("\\s*Синий\\s*")) {return BLUE;}
        else if (color.matches("\\s*Жёлтый\\s*")) {return YELLOW;}

        return null;
    }
}

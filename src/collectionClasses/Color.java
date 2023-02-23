package src.collectionClasses;

/**
 * Enums of dragon's color
 */
public enum Color {
    BLACK("Чёрный"), BLUE("Синий"), YELLOW("Жёлтый");

    private String color;
    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    /**
     *
     * @param color color in Russian
     * @return color
     */
    public static Color getEnumColor(String color) {
        if (color.matches("\\s*Ч(ё|е)рный\\s*")) {return BLACK;}
        else if (color.matches("\\s*Синий\\s*")) {return BLUE;}
        else if (color.matches("\\s*Ж(ё|е)лтый\\s*")) {return YELLOW;}

        return null;
    }

    /**
     *
     * @param color ordinal+1 color
     * @return color
     */
    public static Color getColorByNumber(String color) {
        if (color.matches("\\s*1\\s*")) {return BLACK;}
        else if (color.matches("\\s*2\\s*")) {return BLUE;}
        else if (color.matches("\\s*3\\s*")) {return YELLOW;}

        return null;
    }
}

package src.collectionClasses;

public enum DragonType {
    WATER("Водный"), UNDERGROUND("Подземельный"), AIR("Воздушный"), FIRE("Огненный");

    private String type;
    DragonType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static DragonType getEnumType(String type) {
        if (type.matches("\\s*Водный\\s*")) {return WATER;}
        else if (type.matches("\\s*Подземельный\\s*")) {return UNDERGROUND;}
        else if (type.matches("\\s*Воздушный\\s*")) {return AIR;}
        else if (type.matches("\\s*Огненный\\s*")) {return FIRE;}

        return null;
    }

    public static DragonType getTypeByNumber(String type) {
        if (type.matches("\\s*1\\s*")) {return WATER;}
        else if (type.matches("\\s*2\\s*")) {return UNDERGROUND;}
        else if (type.matches("\\s*3\\s*")) {return AIR;}
        else if (type.matches("\\s*4\\s*")) {return FIRE;}

        return null;
    }
}

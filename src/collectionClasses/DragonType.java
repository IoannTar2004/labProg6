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
}

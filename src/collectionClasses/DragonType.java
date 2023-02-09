package src.collectionClasses;

public enum DragonType {
    WATER("Водяной"), UNDERGROUND("Подземельный"), AIR("Воздушный"), FIRE("Огненный");

    private String type;
    DragonType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

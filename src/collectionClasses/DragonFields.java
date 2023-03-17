package src.collectionClasses;

public enum DragonFields {
    NAME("name"), COORDINATES("coordinates"), AGE("age"), COLOR("color"), TYPE("type"), CHARACTER("character"), CAVE("cave");

    private String field;

    DragonFields(String field) {
        this.field = field;
    }
}

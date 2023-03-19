package src.collectionClasses;

public enum DragonFields {
    NAME("name"), COORDINATES("coordinates"), AGE("age"), COLOR("color"), TYPE("type"), CHARACTER("character"), CAVE("cave");

    private String field;

    DragonFields(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public static DragonFields getFieldByNumber(String number) {
        int num = Integer.parseInt(number);
        for (DragonFields fields: DragonFields.values()) {
            if (fields.ordinal()+1 == num) {
                return fields;
            }
        }
        return null;
    }
}

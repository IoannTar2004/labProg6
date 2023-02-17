package src.collectionClasses;

public enum DragonCharacter {
    CUNNING("Хитрый"), EVIL("Злой"), CHAOTIC("Хаотичный");

    private String character;
    DragonCharacter(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public static DragonCharacter getEnumCharacter(String character) {
        if (character.matches("\\s*Хитрый\\s*")) {return CUNNING;}
        else if (character.matches("\\s*Злой\\s*")) {return EVIL;}
        else if (character.matches("\\s*Хаотичный\\s*")) {return CHAOTIC;}

        return null;
    }
}

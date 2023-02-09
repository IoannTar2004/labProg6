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
}

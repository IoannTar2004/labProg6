package src.collectionClasses;

public enum DragonFields {
    ID, NAME, COORDINATES, AGE, COLOR, TYPE, CHARACTER, CAVE;

    public static DragonFields getFieldByNumber(String num) {
        if (num.matches("\\s*1\\s*")) {return NAME;}
        else if (num.matches("\\s*2\\s*")) {return COORDINATES;}
        else if (num.matches("\\s*3\\s*")) {return AGE;}
        else if (num.matches("\\s*4\\s*")) {return COLOR;}
        else if (num.matches("\\s*5\\s*")) {return TYPE;}
        else if (num.matches("\\s*6\\s*")) {return CHARACTER;}
        else if (num.matches("\\s*7\\s*")) {return CAVE;}

        return null;
    }
}

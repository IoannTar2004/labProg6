package src.commands;

import src.collectionClasses.CollectionManager;

public class CommandShow implements Command{
    public static void execute() {
        for(int i = 0; i < CollectionManager.length(); i++) {
            System.out.println("Имя: " + CollectionManager.getName(i) + " | " +
                    "id: " + CollectionManager.getId(i) + " | " +
                    "coordinates: " + CollectionManager.getCoordinates(i) + " | " +
                    "возраст: " + CollectionManager.getAge(i) + " | " +
                    "дата: " + CollectionManager.getCreationDate(i) + " | "+
                    "цвет: " + CollectionManager.getColor(i) + " | " +
                    "тип: " + CollectionManager.getType(i) + " | " +
                    "характер: " + CollectionManager.getCharacter(i) + " | " +
                    "глубина пещеры: " + CollectionManager.getCave(i));
        }
        System.out.println();
    }
}

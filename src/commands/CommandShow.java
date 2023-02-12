package src.commands;

import src.collectionClasses.CollectionManager;

public class CommandShow {
    public static void execute() {
        if (CollectionManager.length() > 0) {
            for (int i = 0; i < CollectionManager.length(); i++) {
                System.out.println("Имя: " + CollectionManager.getName(i) + " | " +
                        "id: " + CollectionManager.getId(i) + " | " +
                        "coordinates: " + CollectionManager.getCoordinates(i) + " | " +
                        "возраст: " + CollectionManager.getAge(i) + " | " +
                        "дата создания: " + CollectionManager.getCreationDate(i) + " | " +
                        "цвет: " + CollectionManager.getColor(i) + " | " +
                        "тип: " + CollectionManager.getType(i) + " | " +
                        "характер: " + CollectionManager.getCharacter(i) + " | " +
                        "глубина пещеры: " + CollectionManager.getCave(i));
            }
        } else {
            System.out.println("Коллекция пуста.");
        }
        System.out.println();
    }
}

package src.commands;

import src.collectionClasses.CollectionManager;

public class CommandHead {
    public static void execute() {
        if (CollectionManager.length() > 0) {
            System.out.println("Имя: " + CollectionManager.getName(0) + " | " +
                    "id: " + CollectionManager.getId(0) + " | " +
                    "coordinates: " + CollectionManager.getCoordinates(0) + " | " +
                    "возраст: " + CollectionManager.getAge(0) + " | " +
                    "дата создания: " + CollectionManager.getCreationDate(0) + " | " +
                    "цвет: " + CollectionManager.getColor(0) + " | " +
                    "тип: " + CollectionManager.getType(0) + " | " +
                    "характер: " + CollectionManager.getCharacter(0) + " | " +
                    "глубина пещеры: " + CollectionManager.getCave(0));
        } else {
            System.out.println("Коллекция пуста!");
        }
    }
}

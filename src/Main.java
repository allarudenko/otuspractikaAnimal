import animals.Animal;
import data.AnimalData;
import data.CommandsData;
import factory.AnimalFactory;
import validators.DataValidator;
import validators.NumberValidator;
import validators.PetNameValidator;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal>animalList = new ArrayList<>();

        AnimalFactory animalFactory = new AnimalFactory();
        DataValidator commandValidator = new DataValidator();
        NumberValidator numberValidator = new NumberValidator();
        PetNameValidator petNameValidator = new PetNameValidator();

         while (true) {
            System.out.println("Введите команду add/list/exit");
        String commandStr = scanner.next().toUpperCase().trim();

        if (!commandValidator.isValidate(commandStr, CommandsData.values())) {
            System.out.println("Вы ввели неверную команду");
            continue;
        }

        CommandsData commandsData = CommandsData.valueOf(commandStr);

        switch (commandsData) {
            case ADD:

                String animalTypeStr = "";
                while (true) {
                    System.out.println("Введите тип животного: cat/dog/duck");
                    animalTypeStr = scanner.next().toUpperCase().trim();

                    if (commandValidator.isValidate(animalTypeStr, AnimalData.values())) {
                      break;
                    }
                    System.out.println("Вы ввели неверный тип животного");

                }

                Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                System.out.println("Введите имя животного");
                animal.setName(scanner.next());

                System.out.println("Введите возраст животного");
                animal.setAge(scanner);

                System.out.println("Введите вес животного");
                animal.setWeight(scanner);

                while (true) {
                    System.out.println("Введите цвет животного");
                    String colorStr = scanner.next();
                    if (petNameValidator.isPetName(colorStr, Pattern.compile("[a-zA-Z]||[а-яА-Я]"))) {
                      animal.setColor(colorStr);
                        break;
                    }
                    System.out.println("Вы ввели неверный цвет животного");
                }

                animalList.add(animal);
                break;
            case LIST:
               for(Animal animalObj: animalList) {
                   System.out.println(animalObj. toString());
               }
               break;
            case EXIT:
                System.exit(0 );
            }
        }
    }
}
package animals;

import validators.NumberValidator;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Animal {

        private String name = "";
        private int age = -1;
        private int weight = -1;
        private String color = "";

        private NumberValidator numberValidator = new NumberValidator();

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }
        public void setAge(Scanner scanner) {

            int animalAge = -1;
            while (true) {
                String ageStr = scanner.next();
                    if (numberValidator.isNumber(ageStr, Pattern.compile("\\b([0-9]|[1-9][0-9]|100)\\b"))) {
                    animalAge = Integer.parseInt(ageStr);
                    if (animalAge > 50 || animalAge <=0) {
                        System.out.println("Ошибка возраста");
                        continue;
                    }
                    break;
                }
                System.out.println("Ошибка возраста");
            }

                    this.age = animalAge;
        }

        public int getWeight() {
            return weight;
        }
        public void setWeight(Scanner scanner) {
            int animalWeight = -1;
            while (true) {
                String weightSrt = scanner.next();
                if (numberValidator.isNumber(weightSrt, Pattern.compile("\\b([0-9]|[1-9][0-9]|100)\\b"))) {
                    animalWeight = Integer.parseInt(weightSrt);
                    if (animalWeight > 50 || animalWeight <=0) {
                        System.out.println("Ошибка возраста");
                        continue;
                    }
                    break;
                }
                System.out.println("Ошибка возраста");
            }
            this.weight = animalWeight;
        }

        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color= color;
        }

        public void Say(){
            System.out.println("Я говорю");
        }
        public void Go(){
            System.out.println("Я иду");
        }
        public void Drink(){
            System.out.println("Я пью");
        }
        public void Eat(){
            System.out.println("Я ем");
        }

    @Override
    public String toString() {

            String yearPadeg = getYearPadeg();
            if(yearPadeg == null) {
                return "Возраст введен неверно";
            }

        return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
                this.name,
                this.age,
                yearPadeg,
                this.weight,
                this.color
        );
    }

    private String getYearPadeg() {

            if(this.age <= 0 || this.age > 50) {
                return null;
            }

            if(this.age >= 11 && this.age <= 19) {
                return "лет";
            }

            int ostatok = this.age % 10;
            if(ostatok == 0 || ostatok >= 5) {
                return "лет";
            }

            if(ostatok == 1) {
                return "год";
            }

            return "года";


}

}

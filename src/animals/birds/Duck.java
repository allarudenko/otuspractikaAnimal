package animals.birds;

import animals.Animal;

public class Duck extends Animal implements IFly {
    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
}

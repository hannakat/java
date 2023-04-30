package ee.taltech.iti0202.zoo.animal;

import ee.taltech.iti0202.zoo.animal.Animal;

import java.util.Random;

import static ee.taltech.iti0202.zoo.animal.Animal.Type.MAMMAL;

public class Monkey extends Animal {

    /**
     * @param name   animal name
     * @param type   animal type
     * @param sound  animal sound
     * @param hungry days when is hungry again
     */
    public Monkey(String name, Type type, String sound, int hungry) {
        super(name, type, sound, hungry);
    }

    /**
     *
     * @param name Monkey's name
     * @param hungry hungry level
     */
    public Monkey(String name, int hungry) {
        super(name, MAMMAL, "", hungry);
    }

    /**
     *
     * @return type mammal
     */
    @Override
    public Type getType() {
        return MAMMAL;
    }

    /**
     *
     * @return make sound
     */
    @Override
    public String makeSound() {
        if (isHungry()) {
            return "BANANA";
        }
        String[] arr = {"uuh", "ääh"};
        Random random = new Random();
        int select = random.nextInt(arr.length);
        return arr[select];
    }
}

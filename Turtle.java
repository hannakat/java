package ee.taltech.iti0202.zoo.animal;

import ee.taltech.iti0202.zoo.animal.Animal;

import static ee.taltech.iti0202.zoo.animal.Animal.Type.AMPHIBIAN;

public class Turtle extends Animal {
    /**
     * @param name   animal name
     * @param type   animal type
     * @param sound  animal sound
     * @param hungry days when is hungry again
     */
    public Turtle(String name, Type type, String sound, int hungry) {
        super(name, type, sound, hungry);
    }

    /**
     *
     * @param name Turtle name
     * @param hungry hungry level
     */
    public Turtle(String name, int hungry) {
        super(name, AMPHIBIAN, "", hungry);
    }

    /**
     *
     * @return turtle type amphibian
     */
    @Override
    public Type getType() {
        return AMPHIBIAN;
    }

    /**
     *
     * @return no sound
     */
    @Override
    public String makeSound() {
        return "";
    }
}

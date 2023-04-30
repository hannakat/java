package ee.taltech.iti0202.zoo.animal;

import ee.taltech.iti0202.zoo.animal.Animal;

import static ee.taltech.iti0202.zoo.animal.Animal.Type.MAMMAL;

public class Lamb extends Animal {
    /**
     * @param name   animal name
     * @param type   animal type
     * @param sound  animal sound
     * @param hungry days when is hungry again
     */
    public Lamb(String name, Type type, String sound, int hungry) {
        super(name, type, sound, hungry);
    }

    /**
     *
     * @param name lamb's name
     * @param hungry hungry level
     */
    public Lamb(String name, int hungry) {
        super(name, MAMMAL, "mää", hungry);
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
     * @return never hungry
     */
    @Override
    public boolean isHungry() {
        return false;
    }

    /**
     *
     * @return always the same sound
     */
    @Override
    public String makeSound() {
        return "mää";
    }
}

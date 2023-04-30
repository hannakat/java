package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;

public class AnimalBuilder {
    private String name;
    private Animal.Type type;
    private String sound;
    private int hungry;

    /**
     *
     * @param name animal name
     * @return name
     */
    public AnimalBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @param type animal type
     * @return type
     */
    public AnimalBuilder withTyoe(Animal.Type type) {
        this.type = type;
        return this;
    }

    /**
     *
     * @param sound animal sound
     * @return sound
     */
    public AnimalBuilder withSound(String sound) {
        this.sound = sound;
        return this;
    }

    /**
     *
     * @param hungry animal is hungry
     * @return is hungry
     */
    public AnimalBuilder withHungry(Integer hungry) {
        this.hungry = hungry;
        return this;
    }

    /**
     *
     * @return Animal
     */
    public Animal build() {
        return new Animal(name, type, sound, hungry);
    }
}

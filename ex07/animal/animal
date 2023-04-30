package ee.taltech.iti0202.zoo.animal;

import ee.taltech.iti0202.zoo.Zoo;

public class Animal {
    private String name;
    private Type type;
    private String sound;
    private int hungry;
    private int feedingCount = 0;
    private Zoo zoo;

    /**
     *
     * @param name animal name
     * @param type animal type
     * @param sound animal sound
     * @param hungry days when is hungry again
     */
    public Animal(String name, Type type, String sound, int hungry) {
        this.name = name;
        this.type = type;
        this.sound = sound;
        this.hungry = hungry;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * different type's of animals
     */
    public enum Type {
        MAMMAL, BIRD, FISH, REPTILE, AMPHIBIAN;
    }

    /**
     *
     * @return animal's type
     */
    public Type getType() {
        return type;
    }

    /**
     *
     * animal got food and the next feeding day is the count
     */
    public void setFeedingCount() {
        feedingCount = feedingCount + this.hungry;
    }

    /**
     *
     * @return the feeding count
     */
    public int getFeedingCount() {
        return feedingCount;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     *
     * @return true if the animal is hungry
     */
    public boolean isHungry() {
        if (feedingCount < hungry) {
            setFeedingCount();
        }
        setZoo(zoo);
        return zoo.getDaysCount() > feedingCount;
    }

    /**
     * sets new feeding count for animal
     */
    public void feedAnimal() {
        if (isHungry()) {
            setFeedingCount();
        }
    }

    /**
     *
     * @return sound of the animal
     */
    public String makeSound() {
        if (isHungry()) {
            return "";
        }
        return sound;
    }
}

package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Zoo {

    public List<Animal> unfedAnimals = new ArrayList<>();
    public List<Caretaker> caretakers = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();
    private static int daysCount = 1;

    /**
     * every zoo starts from day 1
     */
    public Zoo() {
        daysCount = 1;

    }
    /**
     * next day! Check if any of the animals are hungry and add to unfed animals list
     */
    public void nextDay() {
        for (Animal animal : animals) {
            if (animal.getFeedingCount() <= daysCount + 1) {
                if (!unfedAnimals.contains(animal)) {
                    unfedAnimals.add(animal);
                }
            }
        }
        daysCount++;
    }

    /**
     *
     * @return count the days
     */
    public int getDaysCount() {
        return daysCount;
    }

    /**
     *
     * @param caretaker list of caretakers
     */
    public void addCaretaker(Caretaker caretaker) {
        if (!caretakers.contains(caretaker)) {
            caretakers.add(caretaker);
        }
    }

    /**
     *
     * @param animal list of animals
     */
    public void addAnimalsToZoo(Animal animal) {
        if (!animals.contains(animal)) {
            animals.add(animal);
        }
    }

    /**
     *
     * @return ;ost of unfed animals
     */
    public List<Animal> getUnfedAnimals() {
        return unfedAnimals;
    }

    /**
     *
     * @return list of caretakers
     */
    public List<Caretaker> getCaretakers() {
        return caretakers;
    }

    /**
     *
     * @return list of animals at the zoo
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     *
     * @return all the animals and their noises
     */
    public String makeSomeNoise() {
        StringBuilder result = new StringBuilder();
        for (Animal animal : animals) {
            if (animals.indexOf(animal) != animals.size() - 1) {
                result.append(animal.getName()).append(" (").append(animal.getType()).append("): ")
                        .append(animal.makeSound().toUpperCase(Locale.ROOT)).append("\n");
            } else {
                result.append(animal.getName()).append(" (").append(animal.getType()).append("): ")
                        .append(animal.makeSound().toUpperCase(Locale.ROOT));
            }
        }
        return result.toString();
    }

    /**
     *
     * @param animal that the first person did not know how to feed
     * @return if someone from team can feed the animal
     */
    public boolean letColleagueDoTheJob(Animal animal) {
        for (Caretaker caretaker : getCaretakers()) {
            if (caretaker.getCanFeed().contains(animal.getType())) {
                animal.setFeedingCount();
                unfedAnimals.remove(animal);
                return true;
            }
        }
        return false;
    }
}

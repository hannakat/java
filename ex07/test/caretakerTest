package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CaretakerTest {
    private final int six = 6;

    /**
     * caretaker can feed the animal if right type
     */
    @Test
    public void caretakerCanFeedTheRightType() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        miisu.setZoo(zoo);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        papagoi.setZoo(zoo);
        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);
        anaconda.setZoo(zoo);

        Animal.Type type = papagoi.getType();
        Animal.Type type1 = miisu.getType();
        List<Animal.Type> types = List.of(type, type1);

        Caretaker caretaker = new Caretaker("tiiu", types);
        caretaker.setZoo(zoo);

        for (int i = 0; i < six; i++) {
            zoo.nextDay();
        }

        assertTrue(miisu.isHungry());
        assertTrue(papagoi.isHungry());
        assertTrue(anaconda.isHungry());

        List<Animal> toFeed = List.of(miisu, papagoi, anaconda);

        caretaker.feedAnimal(toFeed);

        assertFalse(miisu.isHungry());
        assertTrue(papagoi.isHungry());
        assertTrue(anaconda.isHungry());

        for (int i = 0; i < six; i++) {
            caretaker.feedAnimal(toFeed);
        }

        assertFalse(papagoi.isHungry());
    }

    /**
     * someone feeds the animal, checks every day
     */
    @Test
    public void someCaretakerFeedsTheAnimal() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        miisu.setZoo(zoo);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        papagoi.setZoo(zoo);
        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);
        anaconda.setZoo(zoo);

        Animal.Type type = papagoi.getType();
        Animal.Type type1 = miisu.getType();
        Animal.Type type2 = anaconda.getType();
        List<Animal.Type> types = List.of(type, type1);
        List<Animal.Type> allTypes = List.of(type, type1, type2);

        Caretaker caretaker = new Caretaker("tiiu", types);
        Caretaker caretaker1 = new Caretaker("miiu", allTypes);
        Caretaker caretaker2 = new Caretaker("viiu", allTypes);

        caretaker1.setZoo(zoo);
        caretaker2.setZoo(zoo);
        caretaker.setZoo(zoo);

        assertEquals(List.of(type, type1), caretaker.getCanFeed());

        zoo.addCaretaker(caretaker);
        zoo.addCaretaker(caretaker1);
        zoo.addCaretaker(caretaker2);

        for (int i = 0; i < 5; i++) {
            zoo.nextDay();
            zoo.letColleagueDoTheJob(anaconda);
        }
        assertEquals(3, zoo.getCaretakers().size());
        assertFalse(anaconda.isHungry());
    }

    /**
     * the right caretaker cannot feed the animal but someone else can
     */
    @Test
    public void caretakerFeedAnimalColleagueHelps() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        miisu.setZoo(zoo);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        papagoi.setZoo(zoo);
        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);
        anaconda.setZoo(zoo);

        Animal.Type type = papagoi.getType();
        Animal.Type type1 = miisu.getType();
        Animal.Type type2 = anaconda.getType();
        List<Animal.Type> types = List.of(type, type1);
        List<Animal.Type> allTypes = List.of(type, type1, type2);


        Caretaker caretaker = new Caretaker("tiiu", types);
        Caretaker caretaker1 = new Caretaker("miiu", allTypes);
        Caretaker caretaker2 = new Caretaker("viiu", allTypes);

        caretaker1.setZoo(zoo);
        caretaker2.setZoo(zoo);
        caretaker.setZoo(zoo);

        zoo.addCaretaker(caretaker);
        zoo.addCaretaker(caretaker1);
        zoo.addCaretaker(caretaker2);

        for (int i = 0; i < six; i++) {
            zoo.nextDay();
        }

        assertTrue(miisu.isHungry());
        assertTrue(papagoi.isHungry());
        assertTrue(anaconda.isHungry());

        List<Animal> toFeed = List.of(miisu, papagoi, anaconda);

        caretaker.feedAnimal(toFeed);

        assertFalse(miisu.isHungry());
        assertTrue(papagoi.isHungry());

        for (int i = 0; i < six; i++) {
            caretaker.feedAnimal(toFeed);
        }

        assertFalse(papagoi.isHungry());
    }

    /**
     * no one in their zoo team can feed the animal
     */
    @Test
    public void noOneCanFeedTheAnimal() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        miisu.setZoo(zoo);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        papagoi.setZoo(zoo);
        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);
        anaconda.setZoo(zoo);
        Animal naljane = new Animal("nicky", Animal.Type.AMPHIBIAN, "niuks", 3);
        naljane.setZoo(zoo);

        Animal.Type type = papagoi.getType();
        Animal.Type type1 = miisu.getType();
        Animal.Type type2 = anaconda.getType();
        List<Animal.Type> types = List.of(type, type1);
        List<Animal.Type> allTypes = List.of(type, type1, type2);


        Caretaker caretaker = new Caretaker("tiiu", types);
        Caretaker caretaker1 = new Caretaker("miiu", allTypes);
        Caretaker caretaker2 = new Caretaker("viiu", allTypes);

        caretaker1.setZoo(zoo);
        caretaker2.setZoo(zoo);
        caretaker.setZoo(zoo);

        zoo.addCaretaker(caretaker);
        zoo.addCaretaker(caretaker1);
        zoo.addCaretaker(caretaker2);

        for (int i = 0; i < six; i++) {
            zoo.nextDay();
        }
        caretaker.feedAnimal(List.of(naljane));
        assertTrue(naljane.isHungry());
    }
}

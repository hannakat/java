package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Lamb;
import ee.taltech.iti0202.zoo.animal.Monkey;
import ee.taltech.iti0202.zoo.animal.Turtle;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class AnimalTest {
    private final int six = 6;
    private final int nine = 9;

    /**
     * test the special animal types
     */
    @Test
    public void specialAnimalMonkeyLambTurtleCreate() {
        Monkey ahv = new Monkey("ahvipoiss", 5);
        Monkey ahv2 = new Monkey("ahvipoiss", 5);

        Lamb lamb = new Lamb("lammas", 3);
        Lamb lamb2 = new Lamb("lammas", 3);

        Turtle turtle = new Turtle("kilbu", 3);

        assertEquals(Animal.Type.MAMMAL, ahv.getType());
        assertEquals(Animal.Type.MAMMAL, ahv2.getType());
        assertEquals(Animal.Type.MAMMAL, lamb.getType());
        assertEquals(Animal.Type.AMPHIBIAN, turtle.getType());

        assertEquals("mää", lamb.makeSound());
        assertEquals("", turtle.makeSound());

        assertFalse(lamb2.isHungry());

    }

    /**
     * change type and sound, if put incorrectly.
     */
    @Test
    public void changeSpecialAnimalTypeAutomatically() {
        Zoo zoo = new Zoo();
        Turtle turtle = new Turtle("turtle", Animal.Type.MAMMAL, "hi", 3);
        turtle.setZoo(zoo);

        assertEquals("", turtle.makeSound());
        assertEquals(Animal.Type.AMPHIBIAN, turtle.getType());

        Lamb lamb = new Lamb("lamb", Animal.Type.AMPHIBIAN, "hi", 3);
        lamb.setZoo(zoo);

        assertEquals("mää", lamb.makeSound());
        assertEquals(Animal.Type.MAMMAL, lamb.getType());

        Monkey monkey = new Monkey("monkey", Animal.Type.REPTILE, "uhhaa", 3);
        monkey.setZoo(zoo);

        assertEquals(3, monkey.makeSound().length());
    }

    /**
     * test the special animal sounds
     */
    @Test
    public void specialMonkeyMakeSound() {
        Zoo zoo = new Zoo();
        Monkey ahv = new Monkey("ahf", 5);

        ahv.setZoo(zoo);
        for (int i = 0; i < 10; i++) {
            zoo.nextDay();
        }
        assertEquals("BANANA", ahv.makeSound());
    }

    /**
     * all the animal sounds, normal and hungry
     */
    @Test
    public void animalMakeSoundGetNameTest() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        Animal kutsu = new Animal("kutsu", Animal.Type.MAMMAL, "auh", 4);
        Animal merisiga = new Animal("merisiga", Animal.Type.MAMMAL, "viuks", 2);
        Animal lehm = new Animal("Mustik", Animal.Type.MAMMAL, "ammuu", 3);
        Animal siga = new Animal("pori", Animal.Type.MAMMAL, "roh-roh", 3);

        Animal linnu = new Animal("Viiu", Animal.Type.BIRD, "siuts", 1);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);

        Animal konn = new Animal("konn", Animal.Type.AMPHIBIAN, "krooks", 1);
        Animal mudakonn = new Animal("gonn", Animal.Type.AMPHIBIAN, "grooks", 1);

        Animal ahven = new Animal("gala", Animal.Type.FISH, "gala-gala", 3);
        Animal haug = new Animal("hr haug", Animal.Type.FISH, "gulu-gulu", 2);

        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);

        miisu.setZoo(zoo);
        assertEquals("mjau", miisu.makeSound());
        assertEquals("miisu", miisu.getName());

        kutsu.setZoo(zoo);
        assertEquals("auh", kutsu.makeSound());
        assertEquals("kutsu", kutsu.getName());

        haug.setZoo(zoo);
        anaconda.setZoo(zoo);
        assertEquals("gulu-gulu", haug.makeSound());
        assertEquals("zzzz", anaconda.makeSound());

        for (int i = 0; i < 4; i++) {
            zoo.nextDay();
        }
        assertEquals(5, zoo.getDaysCount());
        assertEquals("", haug.makeSound());
    }

    /**
     * test when animals are hungry, add days
     */
    @Test
    public void animalsAreHungryAfterFiveDaysTest() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);

        miisu.setZoo(zoo);
        papagoi.setZoo(zoo);
        anaconda.setZoo(zoo);
        assertFalse(miisu.isHungry());
        assertFalse(papagoi.isHungry());
        assertFalse(anaconda.isHungry());


        for (int i = 0; i < 4; i++) {
            zoo.nextDay();
        }
        assertEquals(5, zoo.getDaysCount());

        miisu.feedAnimal();
        assertFalse(miisu.isHungry());
        assertEquals(5, miisu.getFeedingCount());

        anaconda.feedAnimal();
        assertFalse(anaconda.isHungry());

        for (int i = 0; i < 4; i++) {
            anaconda.feedAnimal();
        }
        assertFalse(anaconda.isHungry());
        assertEquals(six, anaconda.getFeedingCount());
        anaconda.setFeedingCount();
        assertEquals(nine, anaconda.getFeedingCount());
    }
}

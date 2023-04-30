package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ZooTest {

    private final int nine = 99;
    private final int test = 104;

    /**
     * test new days
     */
    @Test
    public void generateNextDay() {
        Zoo zoo = new Zoo();

        for (int i = 0; i < 4; i++) {
            zoo.nextDay();
        }

        assertEquals(5, zoo.getDaysCount());

        // 100 paeva juurde
        for (int i = 0; i < nine; i++) {
            zoo.nextDay();
        }
        assertEquals(test, zoo.getDaysCount());
    }

    /**
     * test animal list, adding, no duplicates
     */
    @Test
    public void addAndGetAnimalsFromList() {
        Zoo zoo = new Zoo();

        Animal lehm = new Animal("Mustik", Animal.Type.MAMMAL, "ammuu", 3);
        Animal siga = new Animal("pori", Animal.Type.MAMMAL, "roh-roh", 3);

        Animal linnu = new Animal("Viiu", Animal.Type.BIRD, "siuts", 1);

        zoo.addAnimalsToZoo(lehm);
        zoo.addAnimalsToZoo(siga);
        zoo.addAnimalsToZoo(linnu);
        zoo.addAnimalsToZoo(linnu);

        assertEquals(3, zoo.getAnimals().size());
    }

    /**
     * when animals in animal list, every new day has a check for hungry animals
     */
    @Test
    public void addUnfedAnimalsAutomatically() {
        Zoo zoo = new Zoo();

        Animal lehm = new Animal("Mustik", Animal.Type.MAMMAL, "ammuu", 3);
        Animal siga = new Animal("pori", Animal.Type.MAMMAL, "roh-roh", 3);

        Animal linnu = new Animal("Viiu", Animal.Type.BIRD, "siuts", 1);

        zoo.addAnimalsToZoo(lehm);
        zoo.addAnimalsToZoo(siga);
        zoo.addAnimalsToZoo(linnu);

        for (int i = 0; i < 4; i++) {
            zoo.nextDay();
        }

        assertEquals(3, zoo.getUnfedAnimals().size());
    }

    /**
     * every animal makes a correct sound
     */
    @Test
    public void makeSoundNoOneIsHungry() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        miisu.setZoo(zoo);
        Animal kutsu = new Animal("kutsu", Animal.Type.MAMMAL, "auh", 4);
        kutsu.setZoo(zoo);
        Animal merisiga = new Animal("merisiga", Animal.Type.MAMMAL, "viuks", 2);
        merisiga.setZoo(zoo);
        Animal lehm = new Animal("Mustik", Animal.Type.MAMMAL, "ammuu", 3);
        lehm.setZoo(zoo);
        Animal siga = new Animal("pori", Animal.Type.MAMMAL, "roh-roh", 3);
        siga.setZoo(zoo);

        Animal linnu = new Animal("Viiu", Animal.Type.BIRD, "siuts", 1);
        linnu.setZoo(zoo);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        papagoi.setZoo(zoo);

        Animal konn = new Animal("konn", Animal.Type.AMPHIBIAN, "krooks", 1);
        konn.setZoo(zoo);
        Animal mudakonn = new Animal("gonn", Animal.Type.AMPHIBIAN, "grooks", 1);
        mudakonn.setZoo(zoo);

        Animal ahven = new Animal("gala", Animal.Type.FISH, "gala-gala", 3);
        ahven.setZoo(zoo);
        Animal haug = new Animal("hr haug", Animal.Type.FISH, "gulu-gulu", 2);
        haug.setZoo(zoo);

        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);
        anaconda.setZoo(zoo);

        assertEquals(1, zoo.getDaysCount());
        zoo.addAnimalsToZoo(mudakonn);
        zoo.addAnimalsToZoo(konn);
        zoo.addAnimalsToZoo(ahven);
        zoo.addAnimalsToZoo(haug);
        zoo.addAnimalsToZoo(anaconda);
        zoo.addAnimalsToZoo(miisu);
        zoo.addAnimalsToZoo(kutsu);
        zoo.addAnimalsToZoo(merisiga);
        zoo.addAnimalsToZoo(lehm);
        zoo.addAnimalsToZoo(siga);
        zoo.addAnimalsToZoo(linnu);
        zoo.addAnimalsToZoo(papagoi);

        System.out.println(zoo.makeSomeNoise());
        String result = ("""
                gonn (AMPHIBIAN): GROOKS
                konn (AMPHIBIAN): KROOKS
                gala (FISH): GALA-GALA
                hr haug (FISH): GULU-GULU
                nicky (FISH): ZZZZ
                miisu (MAMMAL): MJAU
                kutsu (MAMMAL): AUH
                merisiga (MAMMAL): VIUKS
                Mustik (MAMMAL): AMMUU
                pori (MAMMAL): ROH-ROH
                Viiu (BIRD): SIUTS
                Reket (BIRD): TERE-TERE""");

        assertEquals(result, zoo.makeSomeNoise());
    }

    /**
     * caretaker list, add and remove
     */
    @Test
    public void caretakersAddAndRemove() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);

        Animal.Type type = papagoi.getType();
        Animal.Type type1 = miisu.getType();
        Animal.Type type2 = anaconda.getType();
        List<Animal.Type> types = List.of(type, type1);
        List<Animal.Type> allTypes = List.of(type, type1, type2);

        Caretaker caretaker = new Caretaker("tiiu", types);
        Caretaker caretaker1 = new Caretaker("miiu", allTypes);
        Caretaker caretaker2 = new Caretaker("viiu", allTypes);

        zoo.addCaretaker(caretaker);
        zoo.addCaretaker(caretaker1);
        zoo.addCaretaker(caretaker2);

        zoo.getCaretakers().remove(caretaker1);
        assertEquals(2, zoo.getCaretakers().size());
        zoo.addCaretaker(caretaker2);
        assertEquals(2, zoo.getCaretakers().size());
    }

    /**
     * someone in caretakers list can feed the animal
     */
    @Test
    public void someOneFeedsTheAnimal() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);

        Animal.Type type = papagoi.getType();
        Animal.Type type1 = miisu.getType();
        Animal.Type type2 = anaconda.getType();
        List<Animal.Type> types = List.of(type, type1);
        List<Animal.Type> allTypes = List.of(type, type1, type2);

        Caretaker caretaker = new Caretaker("tiiu", types);
        Caretaker caretaker1 = new Caretaker("miiu", allTypes);
        Caretaker caretaker2 = new Caretaker("viiu", allTypes);

        zoo.addCaretaker(caretaker);
        zoo.addCaretaker(caretaker1);
        zoo.addCaretaker(caretaker2);
        for (int i = 0; i < 4; i++) {
            zoo.nextDay();
        }

        assertTrue(zoo.letColleagueDoTheJob(miisu));
    }

    /**
     * no one knows how to feed the animal
     */
    @Test
    public void noOneCanFeedTheAnimal() {
        Zoo zoo = new Zoo();
        Animal miisu = new Animal("miisu", Animal.Type.MAMMAL, "mjau", 5);
        Animal papagoi = new Animal("Reket", Animal.Type.BIRD, "tere-tere", 1);
        Animal anaconda = new Animal("nicky", Animal.Type.FISH, "zzzz", 3);

        Animal naljane = new Animal("viktor", Animal.Type.AMPHIBIAN, "ugh", 2);

        Animal.Type type = papagoi.getType();
        Animal.Type type1 = miisu.getType();
        Animal.Type type2 = anaconda.getType();
        List<Animal.Type> types = List.of(type, type1);
        List<Animal.Type> allTypes = List.of(type, type1, type2);

        Caretaker caretaker = new Caretaker("tiiu", types);
        Caretaker caretaker1 = new Caretaker("miiu", allTypes);
        Caretaker caretaker2 = new Caretaker("viiu", allTypes);

        zoo.addCaretaker(caretaker);
        zoo.addCaretaker(caretaker1);
        zoo.addCaretaker(caretaker2);

        for (int i = 0; i < 4; i++) {
            zoo.nextDay();
        }
        assertFalse(zoo.letColleagueDoTheJob(naljane));
    }
}

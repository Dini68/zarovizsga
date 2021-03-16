package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog d: dogs) {
            d.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog d: dogs) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        throw new IllegalArgumentException("No such dog with name: " + name);
    }
    public void playWith(String name, int hours) {
        Dog dog = findByName(name);
        dog.play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> namesOfHappyDogs = new ArrayList<>();
        for (Dog d: dogs) {
            if (d.getHappiness() > minHappiness) {
                namesOfHappyDogs.add(d.getName());
            }
        }
        return namesOfHappyDogs;
    }
}

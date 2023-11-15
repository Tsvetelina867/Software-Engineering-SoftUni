package PolymorphismLab.Animals;

import PolymorphismLab.Animals.Animal;

public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "PolymorphismLab.WildFarm.Meat");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }


}
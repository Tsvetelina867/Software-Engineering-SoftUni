package DefiningClassesExercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(String companyName, String department, double salary) {
        this.company = new Company(companyName, department, salary);
    }

    public void addPokemon(String name, String type) {
        pokemons.add(new Pokemon(name, type));
    }

    public void addParent(String name, String birthday) {
        parents.add(new Parent(name, birthday));
    }

    public void addChild(String name, String birthday) {
        children.add(new Child(name, birthday));
    }

    public void setCar(String model, int speed) {
        car = new Car(model, speed);
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println(name);
        System.out.println("Company:");
        if (company != null) {
            System.out.println(company.toString());
        }

        System.out.println("Car:");
        if (car != null) {
            System.out.println(car.toString());
        }

        System.out.println("Pokemon:");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.toString());
        }

        System.out.println("Parents:");
        for (Parent parent : parents) {
            System.out.println(parent.toString());
        }

        System.out.println("Children:");
        for (Child child : children) {
            System.out.println(child.toString());
        }
    }
}

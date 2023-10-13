package DefiningClassesExercise.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void addChild(Person child) {
        children.add(child);
        child.parents.add(this);
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }
    @Override
    public String toString() {
        return name + " " + birthDate;
    }
}

package InheritanceLab;

import InheritanceLab.Animal;

public class Dog extends Animal {
    public void bark() {
        System.out.println("barking...");
    }
    @Override
    public void eat() {
        super.eat();
    }
}

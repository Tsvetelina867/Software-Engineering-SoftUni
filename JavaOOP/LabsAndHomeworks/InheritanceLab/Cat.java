package InheritanceLab;

import InheritanceLab.Animal;

public class Cat extends Animal {
    public void meow() {
        System.out.println("meowing...");
    }

    @Override
    public void eat() {
        super.eat();
    }
}

package EncapsulationExercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Validator.validateString(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateNonNegativeNumber(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= money) {
            products.add(product);
            money -= product.getCost();
        } else {
            throw new IllegalArgumentException(name +" can't afford " + product.getName());
        }
    }
}

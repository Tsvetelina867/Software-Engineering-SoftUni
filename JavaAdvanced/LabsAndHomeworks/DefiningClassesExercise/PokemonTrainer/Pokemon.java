package DefiningClassesExercise.PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }
    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive(Pokemon pokemon) {
        return pokemon.getHealth() > 0;
    }
}

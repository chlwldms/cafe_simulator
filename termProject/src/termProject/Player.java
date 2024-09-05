package termProject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Player implements Serializable {
    private String name;
    private int age;
    private String gender;
    private int level;
    private int coins;
    private int perfectDrinks;
    private Map<String, Recipe> recipes;

    public Player(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.level = 1;
        this.coins = 0;
        this.perfectDrinks = 0;
        this.recipes = new HashMap<>();
        this.recipes.put("Iced Americano", new Recipe("Iced Americano", 1, 200, 0, 0, 1));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getLevel() {
        return level;
    }

    public int getCoins() {
        return coins;
    }

    public int getPerfectDrinks() {
        return perfectDrinks;
    }

    public Map<String, Recipe> getRecipes() {
        return recipes;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void levelUp() {
        this.level++;
    }

    public void purchaseRecipe(Recipe recipe) {
        this.coins -= recipe.getPrice();
        this.recipes.put(recipe.getName(), recipe);
    }

    public boolean hasRecipe(String name) {
        return recipes.containsKey(name);
    }

    public void incrementPerfectDrinks() {
        this.perfectDrinks++;
    }

    public void resetPerfectDrinks() {
        this.perfectDrinks = 0;
    }
}

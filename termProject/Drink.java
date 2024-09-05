package termProject;

import java.util.Scanner;

public abstract class Drink {
    protected int coffeeShots;
    protected int waterAmount;
    protected int milkAmount;

    public Drink(int coffeeShots, int waterAmount, int milkAmount) {
        this.coffeeShots = coffeeShots;
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
    }

    public abstract void prepareDrink(Scanner scanner);

    public int calculateDifference(Recipe recipe) {
        int difference = 0;
        difference += Math.abs(coffeeShots - recipe.getCoffeeShots());
        difference += Math.abs(waterAmount - recipe.getWaterAmount());
        difference += Math.abs(milkAmount - recipe.getMilkAmount());
        return difference;
    }
}

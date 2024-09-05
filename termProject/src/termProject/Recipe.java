package termProject;

import java.io.Serializable;

public class Recipe implements Serializable {
    private String name;
    private int coffeeShots;
    private int waterAmount;
    private int milkAmount;
    private int price;
    private int requiredLevel;

    public Recipe(String name, int coffeeShots, int waterAmount, int milkAmount, int price, int requiredLevel) {
        this.name = name;
        this.coffeeShots = coffeeShots;
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.price = price;
        this.requiredLevel = requiredLevel;
    }

    public String getName() {
        return name;
    }

    public int getCoffeeShots() {
        return coffeeShots;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getMilkAmount() {
        return milkAmount;
    }

    public int getPrice() {
        return price;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    @Override
    public String toString() {
        return name + " (커피 샷: " + coffeeShots + ", 물: " + waterAmount + "ml, 우유: " + milkAmount + "ml, 가격: " + price + "코인, 레벨 " + requiredLevel + " 필요)";
    }
}

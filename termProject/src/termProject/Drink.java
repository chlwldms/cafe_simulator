package termProject;

import java.util.Scanner;

public abstract class Drink { //drink를 추상 클래스로 선언, 자식 클래스에서 사용할 coffeeShots, waterAmount, milkAmout를 선언. 추상 클래스는 자식 클래스에서 무조건 overriding 해줘야 함
    protected int coffeeShots;
    protected int waterAmount;
    protected int milkAmount;

    public Drink(int coffeeShots, int waterAmount, int milkAmount) { //생성자 선언
        this.coffeeShots = coffeeShots;
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
    }

    public abstract void prepareDrink(Scanner scanner); //prepareDrink를 추상 클래스로 선언, 각 자식 클래스에서 구체적으로 구현

    public int calculateDifference(Recipe recipe) { //recipe와 사용자 입력값을 비교하여 difference 계산
        int difference = 0;
        difference += Math.abs(coffeeShots - recipe.getCoffeeShots());
        difference += Math.abs(waterAmount - recipe.getWaterAmount());
        difference += Math.abs(milkAmount - recipe.getMilkAmount());
        return difference;
    }
}

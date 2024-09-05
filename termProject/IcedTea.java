package termProject;

import java.util.Scanner;

class IcedTea extends Drink {
    private int teaPowderAmount;

    public IcedTea() {
        super(0, 0, 0);
        this.teaPowderAmount = 0;
    }

    @Override
    public void prepareDrink(Scanner scanner) {
        System.out.print("차 가루 양 (g): ");
        this.teaPowderAmount = scanner.nextInt();
        System.out.print("물의 양 (ml): ");
        this.waterAmount = scanner.nextInt();
        scanner.nextLine(); // consume newline
    }

    @Override
    public int calculateDifference(Recipe recipe) {
        int difference = super.calculateDifference(recipe);
        // 차 가루 양 차이 계산 추가
        return difference;
    }
}

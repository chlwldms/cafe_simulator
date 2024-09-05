package termProject;

import java.util.Scanner;

public class VanillaLatte extends Drink {
    private int vanillaSyrupPumps;

    public VanillaLatte() {
        super(0, 0, 0);
        this.vanillaSyrupPumps = 0;
    }

    @Override
    public void prepareDrink(Scanner scanner) {
        System.out.print("커피 샷 수: ");
        this.coffeeShots = scanner.nextInt();
        System.out.print("우유의 양 (ml): ");
        this.milkAmount = scanner.nextInt();
        System.out.print("바닐라 시럽 펌프 수: ");
        this.vanillaSyrupPumps = scanner.nextInt();
        scanner.nextLine(); // consume newline
    }

    @Override
    public int calculateDifference(Recipe recipe) {
        int difference = super.calculateDifference(recipe);
        // 바닐라 시럽 펌프 차이 계산 추가
        return difference;
    }
}

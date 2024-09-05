package termProject;

import java.util.Scanner;

public class StrawberryLatte extends Drink {
    private int strawberrySyrupPumps;

    public StrawberryLatte() {
        super(0, 0, 0);
        this.strawberrySyrupPumps = 0;
    }

    @Override
    public void prepareDrink(Scanner scanner) {
        System.out.print("딸기 시럽 펌프 수: ");
        this.strawberrySyrupPumps = scanner.nextInt();
        System.out.print("우유의 양 (ml): ");
        this.milkAmount = scanner.nextInt();
        scanner.nextLine(); // consume newline
    }

    @Override
    public int calculateDifference(Recipe recipe) {
        int difference = super.calculateDifference(recipe);
        // 딸기 시럽 펌프 차이 계산 추가
        return difference;
    }
}

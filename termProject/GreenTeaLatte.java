package termProject;

import java.util.Scanner;

public class GreenTeaLatte extends Drink {
    private int greenTeaSpoons;

    public GreenTeaLatte() {
        super(0, 0, 0);
        this.greenTeaSpoons = 0;
    }

    @Override
    public void prepareDrink(Scanner scanner) {
        System.out.print("녹차 가루 스푼 수: ");
        this.greenTeaSpoons = scanner.nextInt();
        System.out.print("우유의 양 (ml): ");
        this.milkAmount = scanner.nextInt();
        scanner.nextLine(); // consume newline
    }

    @Override
    public int calculateDifference(Recipe recipe) {
        int difference = super.calculateDifference(recipe);
        // 녹차 가루 스푼 차이 계산 추가
        return difference;
    }
}

package termProject;

import java.util.Scanner;

public class Cappuccino extends Drink {
    public Cappuccino() {
        super(0, 0, 0);
    }

    @Override
    public void prepareDrink(Scanner scanner) {
        System.out.print("커피 샷 수: ");
        this.coffeeShots = scanner.nextInt();
        System.out.print("우유의 양 (ml): ");
        this.milkAmount = scanner.nextInt();
        scanner.nextLine(); // consume newline
    }
}

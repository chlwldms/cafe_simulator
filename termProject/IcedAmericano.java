package termProject;

import java.util.Scanner;

public class IcedAmericano extends Drink {
    public IcedAmericano() {
        super(0, 0, 0);
    }

    @Override
    public void prepareDrink(Scanner scanner) {
        System.out.print("커피 샷 수: ");
        this.coffeeShots = scanner.nextInt();
        System.out.print("물의 양 (ml): ");
        this.waterAmount = scanner.nextInt();
        scanner.nextLine(); // consume newline
    }
}

package termProject;

import java.util.Scanner;

public class IcedAmericano extends Drink { //부모 클래스인 drink로부터 상속 받음
    public IcedAmericano() {  //생성자 선언
        super(0, 0, 0);
    }

    @Override
    public void prepareDrink(Scanner scanner) {
        System.out.print("커피 샷 수: ");
        this.coffeeShots = scanner.nextInt();
        System.out.print("물의 양 (ml): ");
        this.waterAmount = scanner.nextInt();
        scanner.nextLine();
    }
}

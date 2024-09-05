package termProject;

import java.io.*;
import java.util.*;

public class CafeGame {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Player> players = new HashMap<>();
    private static Player currentPlayer;
    private static Map<String, Recipe> availableRecipes = new HashMap<>();

    public static void main(String[] args) {
        loadPlayers();
        initializeAvailableRecipes();

        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPlayer();
                    break;
                case 2:
                    selectPlayer();
                    break;
                case 3:
                    deletePlayer();
                    break;
                case 4:
                    savePlayers();
                    System.out.println("게임 저장 완료! 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("================================");
        System.out.println("1. 플레이어 추가");
        System.out.println("2. 플레이어 선택");
        System.out.println("3. 플레이어 삭제");
        System.out.println("4. 게임 저장 및 종료");
        System.out.println("================================");
        System.out.print("선택: ");
    }

    private static void addPlayer() {
        System.out.println("플레이어의 이름을 입력하세요:");
        String name = scanner.nextLine();
        System.out.println("플레이어의 나이를 입력하세요:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("플레이어의 성별을 입력하세요:");
        String gender = scanner.nextLine();

        Player newPlayer = new Player(name, age, gender);
        players.put(name, newPlayer);
        System.out.println("새로운 플레이어가 추가되었습니다.");
    }

    private static void selectPlayer() {
        System.out.println("플레이어 목록:");
        for (String playerName : players.keySet()) {
            System.out.println("- " + playerName);
        }
        System.out.print("선택할 플레이어의 이름을 입력하세요: ");
        String name = scanner.nextLine();

        if (players.containsKey(name)) {
            currentPlayer = players.get(name);
            System.out.println(name + " 플레이어를 선택했습니다.");
            gameLoop();
        } else {
            System.out.println("해당 이름의 플레이어가 없습니다.");
        }
    }

    private static void deletePlayer() {
        System.out.println("플레이어 목록:");
        for (String playerName : players.keySet()) {
            System.out.println("- " + playerName);
        }
        System.out.print("삭제할 플레이어의 이름을 입력하세요: ");
        String name = scanner.nextLine();

        if (players.containsKey(name)) {
            players.remove(name);
            System.out.println(name + " 플레이어가 삭제되었습니다.");
        } else {
            System.out.println("해당 이름의 플레이어가 없습니다.");
        }
    }

    private static void gameLoop() {
        while (true) {
            showGameMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showStore();
                    break;
                case 2:
                    showRecipes();
                    break;
                case 3:
                    makeMenu();
                    break;
                case 4:
                    showPlayerInfo();
                    break;
                case 5:
                    savePlayers();
                    System.out.println("게임 저장 완료! 메인 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }

            showStatus();
        }
    }

    private static void showGameMenu() {
        System.out.println("================================");
        System.out.println("1. 상점");
        System.out.println("2. 레시피 확인");
        System.out.println("3. 메뉴 만들기");
        System.out.println("4. 플레이어 정보 확인");
        System.out.println("5. 게임 저장 및 메인 메뉴로 돌아가기");
        System.out.println("================================");
        System.out.print("선택: ");
    }

    private static void showStore() {
        System.out.println("상점 - 구매 가능한 레시피 목록:");
        for (Recipe recipe : availableRecipes.values()) {
            String status = currentPlayer.hasRecipe(recipe.getName()) ? " (구매 완료)" : "";
            System.out.println(recipe.getName() + " - 가격: " + recipe.getPrice() + " 코인 (레벨 " + recipe.getRequiredLevel() + " 필요)" + status);
        }
        System.out.print("구매할 레시피 이름을 입력하세요 (취소: 0): ");
        String recipeName = scanner.nextLine();

        if (!recipeName.equals("0") && availableRecipes.containsKey(recipeName)) {
            Recipe recipe = availableRecipes.get(recipeName);
            if (currentPlayer.getLevel() >= recipe.getRequiredLevel() && currentPlayer.getCoins() >= recipe.getPrice()) {
                currentPlayer.purchaseRecipe(recipe);
                System.out.println(recipe.getName() + " 레시피를 구매했습니다!");
            } else {
                System.out.println("구매 조건을 만족하지 못했습니다. 레벨이나 코인을 확인하세요.");
            }
        } else if (!recipeName.equals("0")) {
            System.out.println("해당 이름의 레시피가 없습니다.");
        }
    }

    private static void showRecipes() {
        System.out.println("현재 가지고 있는 레시피:");
        for (Recipe recipe : currentPlayer.getRecipes().values()) {
            System.out.println("- " + recipe);
        }
        waitForUser();
    }

    private static void makeMenu() {
        List<Recipe> allRecipes = new ArrayList<>(availableRecipes.values());
        Recipe randomRecipe = allRecipes.get(new Random().nextInt(allRecipes.size()));
        System.out.println("손님이 주문한 메뉴: " + randomRecipe.getName());

        Drink drink;
        switch (randomRecipe.getName()) {
            case "Iced Americano":
                drink = new IcedAmericano();
                break;
            case "Vanilla Latte":
                drink = new VanillaLatte();
                break;
            case "Cappuccino":
                drink = new Cappuccino();
                break;
            case "Strawberry Latte":
                drink = new StrawberryLatte();
                break;
            case "Green Tea Latte":
                drink = new GreenTeaLatte();
                break;
            case "Iced Tea":
                drink = new IcedTea();
                break;
            default:
                System.out.println("알 수 없는 메뉴입니다.");
                return;
        }

        drink.prepareDrink(scanner);
        int earnedCoins = calculateEarnings(drink, randomRecipe);
        currentPlayer.addCoins(earnedCoins);
        System.out.println(randomRecipe.getName() + "을(를) 만들었습니다!");
        System.out.println(earnedCoins + " 코인을 얻었습니다!");

        if (earnedCoins == 500) {
            currentPlayer.incrementPerfectDrinks();
            if (currentPlayer.getPerfectDrinks() >= 3) {
                currentPlayer.levelUp();
                currentPlayer.resetPerfectDrinks();
                System.out.println("레벨업! 현재 레벨: " + currentPlayer.getLevel());
            }
        }

        waitForUser();
    }

    private static int calculateEarnings(Drink drink, Recipe recipe) {
        int difference = drink.calculateDifference(recipe);

        if (difference == 0) {
        	System.out.println("음 ~ 맛있다!");
            return 500; 
        } else if (difference <= 10) {
        	System.out.println("먹을만하네요");
            return 300;
        } else {
        	System.out.println("우웩");
            return 100;
        }
    }

    private static void showPlayerInfo() {
        System.out.println("플레이어 정보:");
        System.out.println("이름: " + currentPlayer.getName());
        System.out.println("나이: " + currentPlayer.getAge());
        System.out.println("성별: " + currentPlayer.getGender());
        waitForUser();
    }

    private static void showStatus() {
        System.out.println("--------------------------------------------");
        System.out.println("현재 레벨: " + currentPlayer.getLevel() + " | 현재 모인 코인의 양: " + currentPlayer.getCoins());
        System.out.println("--------------------------------------------");
        waitForUser();
    }

    private static void loadPlayers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("players.dat"))) {
            players = (Map<String, Player>) ois.readObject();
            System.out.println("플레이어 데이터를 불러왔습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("플레이어 데이터 파일이 없습니다. 새로 만듭니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("플레이어 데이터를 불러오는 중 오류가 발생했습니다.");
        }
    }

    private static void savePlayers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("players.dat"))) {
            oos.writeObject(players);
            System.out.println("플레이어 데이터를 저장했습니다.");
        } catch (IOException e) {
            System.out.println("플레이어 데이터를 저장하는 중 오류가 발생했습니다.");
        }
    }

    private static void initializeAvailableRecipes() {
        availableRecipes.put("Iced Americano", new Recipe("Iced Americano", 1, 200, 0, 0, 1));
        availableRecipes.put("Vanilla Latte", new Recipe("Vanilla Latte", 2, 0, 150, 300, 2));
        availableRecipes.put("Cappuccino", new Recipe("Cappuccino", 2, 0, 100, 300, 2));
        availableRecipes.put("Strawberry Latte", new Recipe("Strawberry Latte", 0, 0, 150, 350, 3));
        availableRecipes.put("Green Tea Latte", new Recipe("Green Tea Latte", 0, 0, 150, 400, 3));
        availableRecipes.put("Iced Tea", new Recipe("Iced Tea", 0, 200, 0, 250, 4));
    }

    private static void waitForUser() {
        System.out.println("계속하려면 엔터를 누르세요...");
        scanner.nextLine();
    }
}

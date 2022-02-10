import java.util.Scanner;

/*@NOTE: This app is made to run in console. Main may be a bit longer.*/
public class Main {
    public static void main(String[] args) {
//        CoffeeMachine State
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 9, 550, 540, 120);
//        CoffeeRequirements State
        Coffee espresso = new Coffee(250, 16, 0, 4);
        Coffee latte = new Coffee(350, 20, 75, 7);
        Coffee cappuccino = new Coffee(200, 12, 100, 6);

        while (true) {
            System.out.print("Coffee left: espresso: " + coffeeMachine.coffeeRemaining(espresso) + " ");
            System.out.print(" latte: " + coffeeMachine.coffeeRemaining(latte) + " ");
            System.out.print(" cappuccino: " + coffeeMachine.coffeeRemaining(cappuccino) + " \n");
            System.out.println("Money: $" + coffeeMachine.getMoney());
            System.out.println();
            System.out.println("What do you want to do ? \n Please type: \n buy\n take \n fill \n exit");
            Scanner scanner = new Scanner(System.in);
            String inputValue = scanner.next();

            if (inputValue.equals("buy")) {
                System.out.println("Select which coffee you want ☕ ? \n a) espresso \n b) latte \n c) cappuccino");
                scanner = new Scanner(System.in);
                String coffeeType = scanner.nextLine();
                System.out.println("enter how many cups: ");
                scanner = new Scanner(System.in);
                int cupQuantity = scanner.nextInt();

                switch (coffeeType) {
                    case "a":
                        if (coffeeMachine.coffeeRemaining(espresso) >= cupQuantity) {
                            coffeeMachine.handleBuy(espresso, cupQuantity);
                        } else {
                            System.out.println("not enough ingredients");
                        }
                        break;
                    case "b":
                        if (coffeeMachine.coffeeRemaining(latte) >= cupQuantity) {
                            coffeeMachine.handleBuy(latte, cupQuantity);
                        } else {
                            System.out.println("not enough ingredients");
                        }
                        break;
                    case "c":
                        if (coffeeMachine.coffeeRemaining(cappuccino) >= cupQuantity) {
                            coffeeMachine.handleBuy(cappuccino, cupQuantity);
                        } else {
                            System.out.println("not enough ingredients");
                        }
                        break;
                    default:
                        System.out.println("Error");
                }
            }
            if (inputValue.equals("take")) {
                coffeeMachine.handleWithdraw();
            }
            if (inputValue.equals("fill")) {
                System.out.println(coffeeMachine.displayRemaining());
                System.out.println("Enter amounts of Water, Milk, Beans, Cup");
                scanner = new Scanner(System.in);
                int water = scanner.nextInt();
                int milk = scanner.nextInt();
                int beans = scanner.nextInt();
                int cup = scanner.nextInt();
                System.out.println("water: " + water + " milk " + milk + " beans " + beans + " cup " + cup);
                coffeeMachine.handleFill(water, milk, beans, cup);
                System.out.println(coffeeMachine.displayRemaining());
            }
            if (inputValue.equals("exit")) {
                break;
            }

        }
    }
}

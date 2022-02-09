import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    private int waterAmount;
    private int cupQuantity;
    private int money;
    private int milkAmount;
    private int beansAmount;

    public CoffeeMachine(int waterAmount, int cupQuantity, int money, int milkAmount, int beansAmount) {
        this.waterAmount = waterAmount;
        this.cupQuantity = cupQuantity;
        this.money = money;
        this.milkAmount = milkAmount;
        this.beansAmount = beansAmount;
    }

    public int coffeeRemaining(Coffee coffee) { //change to available
        int[] arr = new int[4];

        if (coffee.getWaterMl() != 0) {
            arr[0] = this.getWaterAmount() / coffee.getWaterMl();
        } else {
            arr[0] = 2147483647;
        }
        if (coffee.getCoffeeBeansQuantity() != 0) {
            arr[1] = this.getBeansAmount() / coffee.getCoffeeBeansQuantity();
        } else {
            arr[1] = 2147483647; //changed
        }

        if (coffee.getMilkMl() != 0) {
            arr[2] = this.getMilkAmount() / coffee.getMilkMl();
        } else {
            arr[2] = 2147483647;
        }

        arr[3] = this.getCupQuantity();

        return Arrays.stream(arr).min().getAsInt();
    }

    protected void handleBuy(Coffee coffee, int cupQuantity) {
        int water = this.getWaterAmount() - coffee.getWaterMl() * cupQuantity;
        int milk = this.getMilkAmount() - coffee.getMilkMl() * cupQuantity;
        int beans = this.getBeansAmount() - coffee.getCoffeeBeansQuantity() * cupQuantity;
        int price = this.getMoney() + coffee.getPrice() * cupQuantity;
        int cup = this.getCupQuantity() - cupQuantity;

        this.setWaterAmount(water);
        this.setMilkAmount(milk);
        this.setBeansAmount(beans);
        this.setMoney(price);
        this.setCupQuantity(cup);
    }

    protected void handleFill(int waterAmount, int milkAmount, int beansAmount, int cupQuantity) {
        this.setWaterAmount(this.getWaterAmount() + waterAmount);
        this.setMilkAmount(this.getMilkAmount() + milkAmount);
        this.setBeansAmount(this.getBeansAmount() + beansAmount);
        this.setCupQuantity(this.getCupQuantity() + cupQuantity);
    }

    protected void handleWithdraw() {
        this.setMoney(0);
    }

    protected String displayRemaining() {
        return "Remaining: Water: " + this.getWaterAmount()
                + " Milk: " + this.getMilkAmount()
                + " Beans: " + this.getBeansAmount()
                + " Cup: " + this.getCupQuantity();
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public int getCupQuantity() {
        return cupQuantity;
    }

    public void setCupQuantity(int cupQuantity) {
        this.cupQuantity = cupQuantity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMilkAmount() {
        return milkAmount;
    }

    public void setMilkAmount(int milkAmount) {
        this.milkAmount = milkAmount;
    }

    public int getBeansAmount() {
        return beansAmount;
    }

    public void setBeansAmount(int beansAmount) {
        this.beansAmount = beansAmount;
    }

}
public class Coffee {
    private int waterMl /*renamed*/;
    private int milkMl /*= renamed*/;
    private int coffeeBeansQuantity /**/;
    private int price;

    public Coffee(int waterMl, int coffeeBeansQuantity, int milkMl, int price) {
        this.waterMl = waterMl;
        this.coffeeBeansQuantity = coffeeBeansQuantity;
        this.milkMl = milkMl;
        this.price = price;
    }

    protected void displayCoffeeRequirements() { // Rename/Delete
        System.out.println(this.waterMl + "ml of water\n" + this.milkMl + "ml of milk\n" + this.coffeeBeansQuantity + "g of coffee beans");
    }

    public int getWaterMl() {
        return waterMl;
    }

    public void setWaterMl(int waterMl) {
        this.waterMl = waterMl;
    }

    public int getMilkMl() {
        return milkMl;
    }

    public void setMilkMl(int milkMl) {
        this.milkMl = milkMl;
    }

    public int getCoffeeBeansQuantity() {
        return coffeeBeansQuantity;
    }

    public void setCoffeeBeansQuantity(int coffeeBeansQuantity) {
        this.coffeeBeansQuantity = coffeeBeansQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

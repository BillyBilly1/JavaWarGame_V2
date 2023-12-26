package entity.food_pack;

public enum FoodPackage implements IFoodPackage{

    MINI_PACK(56, 50),
    SMALL_PACK(110, 100),
    MEDIUM_PACK(310, 300),
    LARGE_PACK(500, 500),
    HUGE_PACK(900, 1000);


    private final int price;
    private final int foodAmount;

    FoodPackage(int price, int foodAmount) {
        this.price = price;
        this.foodAmount = foodAmount;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getFoodAmount() {
        return this.foodAmount;
    }
}

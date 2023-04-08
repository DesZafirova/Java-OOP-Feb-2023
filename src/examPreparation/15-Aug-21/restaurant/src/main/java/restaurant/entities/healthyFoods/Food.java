package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import  static restaurant.common.ExceptionMessages.*;

public abstract class Food implements HealthyFood {
    private String name;
    private double portion;
    private double price;

    protected Food(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if(portion <= 0){
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }
    //•	name - String
    //o	If the name is null or whitespace, throw an IllegalArgumentException with message "Name cannot be null or white space!"
    //•	portion - double
    //o	If the portion is less or equal to 0, throw an IllegalArgumentException with message "Portion cannot be less or equal to zero!"
    //•	price - double
    //o	If the price is less or equal to 0, throw an IllegalArgumentException with message "Price cannot be less or equal to zero!"

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

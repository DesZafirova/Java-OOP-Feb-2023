package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth{
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();

        this.isReserved = false;
    }

    protected void setCapacity(int capacity) {
        if(capacity < 0){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }


    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
        this.setPrice(price);

    }

    @Override
    public double getBill() {
        double billFromCocktails = cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        double billFromDelicacies = delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        return billFromCocktails + billFromDelicacies + getPrice();
    }

    @Override
    public void clear() {
        this.isReserved = false;
        numberOfPeople = 0;
        cocktailOrders.clear();
        delicacyOrders.clear();
        price = 0;

    }

    public void setPrice(double price) {
        this.price = numberOfPeople * pricePerPerson;
    }
}

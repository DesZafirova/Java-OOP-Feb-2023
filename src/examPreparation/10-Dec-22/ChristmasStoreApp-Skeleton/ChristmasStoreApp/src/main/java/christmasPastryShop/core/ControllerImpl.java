package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.*;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;


    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = type.equals("Stolen") ? new Stolen(name, price)
                : new Gingerbread(name, price);
        Delicacy isExist = delicacyRepository.getByName(name);
        if (isExist == null) {
            delicacyRepository.add(delicacy);
            return String.format(DELICACY_ADDED, name, type);
        }
        throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = type.equals("Hibernation") ? new Hibernation(name, size, brand)
                : new MulledWine(name, size, brand);
        Cocktail isExist = cocktailRepository.getByName(name);
        if (isExist == null) {
            cocktailRepository.add(cocktail);
            return String.format(COCKTAIL_ADDED, name, brand);
        }
        throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));

    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = type.equals("OpenBooth") ? new OpenBooth(boothNumber, capacity)
                : new PrivateBooth(boothNumber, capacity);
        Booth isExist = boothRepository.getByNumber(boothNumber);
        if (isExist == null) {
            boothRepository.add(booth);
            return String.format(BOOTH_ADDED, boothNumber);
        }
        throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Collection<Booth> booths = this.boothRepository.getAll();
        Booth booth = booths.stream()
                .filter(b -> !b.isReserved() && b.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        String output;
        if (booth != null) {
            booth.reserve(numberOfPeople);
            output = String.format(BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
        } else {
            output = String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        return output;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        totalIncome += bill;
        booth.clear();

        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}

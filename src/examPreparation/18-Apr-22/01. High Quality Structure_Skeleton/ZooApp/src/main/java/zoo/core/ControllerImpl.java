package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if(areaType.equals("WaterArea")){
            area = new WaterArea(areaName);
        }else if(areaType.equals("LandArea")){
            area = new LandArea(areaName);
        }else{
            throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if(foodType.equals("Vegetable")){
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        }else{
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if(food == null){
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        foodRepository.remove(food);
        Area area = areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        area.addFood(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        if(animalType.equals("AquaticAnimal")){
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        }else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        Area area = areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        String output;

        if ((area.getClass().getSimpleName().equals("WaterArea") && !animalType.equals("AquaticAnimal")) ||
                (area.getClass().getSimpleName().equals("LandArea") && !animalType.equals("TerrestrialAnimal"))) {
            output = AREA_NOT_SUITABLE;
        }else{
            area.addAnimal(animal);
            output = String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        }

        return output;
        }



    @Override
    public String feedAnimal(String areaName) {
        Area area = areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        Collection<Animal> animals = area.getAnimals();
        for (Animal animal : animals) {
            animal.eat();
        }

        return String.format(ANIMALS_FED, animals.size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        Collection<Animal> animals = area.getAnimals();
        double sum = animals.stream().mapToDouble(Animal::getKg).sum();
        return String.format(KILOGRAMS_AREA, areaName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Area area : areas) {
            stringBuilder.append(area.getInfo());
        }
        return stringBuilder.toString();
    }
}

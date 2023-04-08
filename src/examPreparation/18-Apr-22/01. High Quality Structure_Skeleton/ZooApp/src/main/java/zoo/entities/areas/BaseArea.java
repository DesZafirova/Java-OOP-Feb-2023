package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {

        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.capacity > animals.size()) {
            animals.add(animal);
        }else{
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }

    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (")
                .append(this.getClass().getSimpleName()).append("):")
                .append(System.lineSeparator());
        sb.append("Animals: ");
       String animalsReport = getAnimals().isEmpty()
               ? "none"
               : animals.stream()
               .map(Animal::getName)
               .collect(Collectors.joining(" "));
        sb.append(animalsReport);
        sb.append(System.lineSeparator());
        sb.append("Foods: ").append(foods.size()).append(System.lineSeparator());
        sb.append(String.format("Calories: %d", this.sumCalories())).append(System.lineSeparator());

        return sb.toString();
    }

}

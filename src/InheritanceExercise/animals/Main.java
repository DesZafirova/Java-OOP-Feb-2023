package InheritanceExercise.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeAnimal = scanner.nextLine();
        while (!"Beast".equals(typeAnimal)) {
            String[] animalInfo = scanner.nextLine().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];
           try{
            switch (typeAnimal) {
                case "Dog":
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog);
                    break;
                case "Frog":
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog);
                    break;
                case "Cat":
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten);
                    break;
            }
        }catch (IllegalArgumentException ex){
               System.out.println(ex.getMessage());
           }
            typeAnimal = scanner.nextLine();
        }
    }
}
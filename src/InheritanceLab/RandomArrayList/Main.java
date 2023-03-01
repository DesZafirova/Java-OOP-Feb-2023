package InheritanceLab.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<Integer>();
        randomArrayList.add(5);
        randomArrayList.add(12);
        System.out.println(randomArrayList.getRandomElement());
    }
}

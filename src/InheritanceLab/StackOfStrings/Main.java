package InheritanceLab.StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        stack.push("bark");
        stack.push("meow");
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }
}

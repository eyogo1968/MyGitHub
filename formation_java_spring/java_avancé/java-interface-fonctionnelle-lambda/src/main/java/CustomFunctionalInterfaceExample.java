public class CustomFunctionalInterfaceExample {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        System.out.println(addition.operate(10, 5)); // 15
    }
}

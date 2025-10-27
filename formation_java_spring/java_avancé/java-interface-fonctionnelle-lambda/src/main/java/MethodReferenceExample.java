import java.util.function.Consumer;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Consumer<String> print = System.out::println;
        print.accept("Hello, method references!");
    }
}
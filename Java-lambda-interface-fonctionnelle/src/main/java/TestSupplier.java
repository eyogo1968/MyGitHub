import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {
        Supplier<String> message = () -> "Bienvenue";
        System.out.println(message.get());
    }
}

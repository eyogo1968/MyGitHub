import java.util.function.Supplier;

public class TestConstructeurReference2 {
    public static void main(String[] args) {
        Supplier<Personne> supplier = () -> new Personne();
        System.out.println(supplier.get());
    }
}
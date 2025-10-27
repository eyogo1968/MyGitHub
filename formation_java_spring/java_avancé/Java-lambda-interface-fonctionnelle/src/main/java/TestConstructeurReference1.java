import java.util.function.Supplier;

public class TestConstructeurReference1 {
    public static void main(String[] args) {
        Supplier<Personne> supplier = Personne::new;
        System.out.println(supplier.get());
    }
}
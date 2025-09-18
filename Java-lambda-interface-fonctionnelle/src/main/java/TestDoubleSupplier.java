import java.util.function.DoubleSupplier;

public class TestDoubleSupplier {

    public static void main(String[] args) {
        DoubleSupplier pi = () -> 3.14116;
        System.out.println(pi.getAsDouble());
    }
}

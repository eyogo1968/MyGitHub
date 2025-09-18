import java.util.function.BooleanSupplier;

public class TestBooleanSupplier {

    public static void main(String[] args) {
        int a = 10;
        int b = 12;
        BooleanSupplier aInferieurAB = () -> a <= b;
        System.out.println(aInferieurAB.getAsBoolean());
    }
}

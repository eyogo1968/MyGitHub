import java.util.function.IntSupplier;

public class TestIntSupplier {

    public static void main(String[] args) {
        int a = 10;
        int b = 12;
        IntSupplier aPlusB = () -> a + b;
        System.out.println(aPlusB.getAsInt());
    }
}

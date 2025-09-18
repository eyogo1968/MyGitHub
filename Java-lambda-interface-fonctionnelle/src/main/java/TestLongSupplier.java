import java.util.function.LongSupplier;

public class TestLongSupplier {

    public static void main(String[] args) {
        int a = 100000000;
        LongSupplier aAuCarre = () -> (long) a * a;
        System.out.println(aAuCarre.getAsLong());
    }
}

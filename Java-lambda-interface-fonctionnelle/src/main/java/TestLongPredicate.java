import java.util.function.LongPredicate;

public class TestLongPredicate {

    private static final Long DIX_MILLE = 10_000L;

    public static void main(String[] args) {
        LongPredicate estPositif = valeur -> valeur >= 0;
        LongPredicate vautDixMille = valeur -> valeur == DIX_MILLE;

        System.out.println(estPositif.test(DIX_MILLE));
        System.out.println(estPositif.and(vautDixMille).test(DIX_MILLE));
        System.out.println(estPositif.negate().test(DIX_MILLE));
        System.out.println(estPositif.or(vautDixMille).test(100L));
    }
}
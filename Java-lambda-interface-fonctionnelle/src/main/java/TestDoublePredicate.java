import java.util.function.DoublePredicate;

public class TestDoublePredicate {

    private static final double DIX_MILLE = 10_000;

    public static void main(String[] args) {
        DoublePredicate estPositif = valeur -> valeur >= 0;
        DoublePredicate vautDixMille = valeur -> valeur == DIX_MILLE;

        System.out.println(estPositif.test(DIX_MILLE));
        System.out.println(estPositif.and(vautDixMille).test(DIX_MILLE));
        System.out.println(estPositif.negate().test(DIX_MILLE));
        System.out.println(estPositif.or(vautDixMille).test(100L));
    }
}
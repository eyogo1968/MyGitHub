import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TestPredicate2 {

    public static void main(String[] args) {
        BiPredicate<Integer, Integer> estSupOuEgal = (x, y) -> x >= y;
        BiPredicate<Integer, Integer> estLaMoitie = (x, y) -> x == y * 2;

        System.out.println("1 " + estSupOuEgal.test(2, 3));
        System.out.println("1 " + estSupOuEgal.test(3, 2));

        System.out.println("2 " + estSupOuEgal.and(estLaMoitie).test(4, 2));
        System.out.println("2 " + estSupOuEgal.and(estLaMoitie).test(3, 2));

        System.out.println("3 " + estSupOuEgal.negate().test(3, 2));

        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(1, 1));
        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(4, 2));
        System.out.println("4 " + estSupOuEgal.or(estLaMoitie).test(2, 4));
    }
}
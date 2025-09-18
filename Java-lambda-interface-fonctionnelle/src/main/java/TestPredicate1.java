import java.util.Objects;
import java.util.function.Predicate;

public class TestPredicate1 {

    public static void main(String[] args) {
        Predicate<String> possedeTailleTrois = s -> s.length() == 3;
        Predicate<String> contientX = s -> s.contains("X");
        Predicate<String> estNonNull = Objects::nonNull;
        Predicate<String> contientXOuTaille3 = contientX.or(possedeTailleTrois);
        Predicate<String> estSMS = Predicate.isEqual("SMS");

        System.out.println("1 "+contientX.negate().test("WXYZ"));
        System.out.println("2 "+contientX.or(possedeTailleTrois).test("WWW"));
        System.out.println("2 "+contientX.or(possedeTailleTrois).test("WX"));
        System.out.println("3 "+contientX.and(possedeTailleTrois).test("WXY"));
        System.out.println("3 "+contientX.and(possedeTailleTrois).test("WWW"));

        System.out.println("4 "+estNonNull.test(null));
        System.out.println("5 "+estNonNull.and(contientX).and(possedeTailleTrois).test("WWW"));
        System.out.println("5 "+estNonNull.and(contientX).and(possedeTailleTrois).test("XX"));
        System.out.println("5 "+estNonNull.and(contientX).and(possedeTailleTrois).test(null));
        System.out.println("6 "+estNonNull.and(contientXOuTaille3).test("WWW"));
        System.out.println("6 "+estNonNull.and(contientXOuTaille3).test("XX"));
        System.out.println("6 "+estNonNull.and(contientXOuTaille3).test(null));
        System.out.println("7 "+estNonNull.and(contientX.or(possedeTailleTrois)).test("WWW"));
        System.out.println("7 "+estNonNull.and(contientX.or(possedeTailleTrois)).test("XX"));
        System.out.println("7 "+estNonNull.and(contientX.or(possedeTailleTrois)).test(null));

        System.out.println("8 "+estSMS.test("SMS"));
        System.out.println("8 "+estSMS.test("ABC"));
        System.out.println("8 "+estSMS.test(null));
    }
}
import java.util.Arrays;
import java.util.List;

public class TestMethodeReference2 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("melon", "abricot", "fraise", "cerise");
        afficher(fruits, (fmt, arg) -> String.format(fmt, arg));
    }

    public static void afficher(List<String> liste, MonFormateur formateur) {
        int i = 0;
        for (String element : liste) {
            i++;
            System.out.print(formateur.formater("%3d %s%n", i, element));
        }
    }
}

@FunctionalInterface
interface MonFormateur {
    String formater(String format, Object... arguments);
}

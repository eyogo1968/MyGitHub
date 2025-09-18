import java.util.Arrays;
import java.util.List;

public class TestMethodeReference3 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("melon", "abricot", "fraise", "cerise");
        afficher(fruits, String::format);
    }

    public static void afficher(List<String> liste, MonFormateur3 formateur) {
        int i = 0;
        for (String element : liste) {
            i++;
            System.out.print(formateur.formater("%3d %s%n", i, element));
        }
    }
}

@FunctionalInterface
interface MonFormateur3 {
    String formater(String format, Object... arguments);
}

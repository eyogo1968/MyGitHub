import java.util.Arrays;
import java.util.Comparator;

public class TestReferenceMethodeUnbound3 {
    public static void main(String[] args) {
        String[] fruits = {"Melon", "abricot", "fraise", "cerise", "mytille"};
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        System.out.println(Arrays.deepToString(fruits));
    }

}
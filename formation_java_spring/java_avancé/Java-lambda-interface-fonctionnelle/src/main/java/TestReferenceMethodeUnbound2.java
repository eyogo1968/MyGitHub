import java.util.Arrays;

public class TestReferenceMethodeUnbound2 {
    public static void main(String[] args) {
        String[] fruits = {"Melon", "abricot", "fraise", "cerise", "mytillee"};
        Arrays.sort(fruits, (s1, s2) -> s1.compareToIgnoreCase(s2) );
        System.out.println(Arrays.deepToString(fruits));
    }
}
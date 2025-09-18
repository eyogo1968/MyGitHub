import java.util.Arrays;

public class TestReferenceMethodeUnbound1 {
    public static void main(String[] args) {
        String[] fruits = {"Melon", "abricot", "fraise", "cerise", "mytille"};
        Arrays.sort(fruits, String::compareToIgnoreCase);
        System.out.println(Arrays.deepToString(fruits));
    }
}
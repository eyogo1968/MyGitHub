import java.util.Arrays;

public class TestReferenceMethodeStatique1 {
    public static void main(String[] args) {
        Integer[] valeurs = {10, 4, 2, 7, 5, 8, 1, 9, 3, 6};
        Arrays.sort(valeurs, Integer::compare);
        System.out.println(Arrays.deepToString(valeurs));
    }
}

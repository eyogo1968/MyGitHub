import java.util.Arrays;

public class TestReferenceMethodeStatique2 {
    public static void main(String[] args) {
        Integer[] valeurs = {10, 4, 2, 7, 5, 8, 1, 9, 3, 6};
        Arrays.sort(valeurs, TestReferenceMethodeStatique2::comparerEntierAscendant);
        System.out.println(Arrays.deepToString(valeurs));
    }

    public static int comparerEntierAscendant(int a, int b) {
        return a - b;
    }
}
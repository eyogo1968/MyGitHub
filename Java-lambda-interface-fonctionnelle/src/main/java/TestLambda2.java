import java.util.Arrays;
import java.util.Comparator;

public class TestLambda2 {

    public static void main(String[] args) {

        /*
            Il est possible d'assigner à un objet d'un type d'une interface fonctionnelle
            une expression lambda qui respecte la déclaration de la méthode abstraite.
         */
        Comparator<String> tri = (o1, o2) -> o1.compareTo(o2);

        String[] elements = new String[] { "aaa","zzz","fff","mmm"};
        Arrays.sort(elements, tri);
        System.out.println(Arrays.toString(elements));
    }
}

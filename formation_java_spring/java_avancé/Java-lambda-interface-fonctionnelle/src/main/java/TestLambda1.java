import java.util.Arrays;

public class TestLambda1 {

    public static void main(String[] args) {

        /*
            On tri un tableau de chaînes de caractères en utilisant la méthode sort() de la classe Arrays.
             Elle attend en paramètre le tableau à trier et une instance de type Comparator.
             Comme l'interface Comparator est une interface fonctionnelle, il est possible d'utiliser une
             expression lambda.
         */
        String[] elements = new String[] { "aaa","zzz","fff","mmm"};
        Arrays.sort(elements, (o1, o2) -> o1.compareTo(o2));
        System.out.println(Arrays.toString(elements));
    }
}

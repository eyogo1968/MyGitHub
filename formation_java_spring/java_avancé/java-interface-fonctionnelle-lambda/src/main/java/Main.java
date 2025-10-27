import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Avant Java 8 Si vous vouliez passer un comportement
        en argument, vous deviez créer une classe anonyme:
         */
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello, "+name+"!");
            }
        };
        greeting.sayHello("Alice");

        /*
        Au lieu d'écrire toute une classe pour filtrer les nombres pairs,
        il suffit de passer une lambda :
         */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evens1 = NumberFilter2.filter(numbers, n -> n % 2 == 0);
        System.out.println("Even numbers: " + evens1); // [2, 4, 6, 8, 10]

        /*
        Si vous avez déjà une méthode qui vérifie si un nombre
        est pair, vous pouvez vous passer totalement de la lambda
         */
        List<Integer> evens2 = NumberFilter2.filter(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), MathUtils::isEven);
        System.out.println("Even numbers: " + evens2);
    }
}

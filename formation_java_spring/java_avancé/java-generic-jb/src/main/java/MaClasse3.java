public class MaClasse3 {

    /*
        Il est parfois nécessaire de restreindre les types qui peuvent être utilisés comme arguments de type dans un type paramétré.
        Par exemple, une méthode qui opère sur des nombres ne peut accepter que des instances de type Number ou de ses sous-classes
        ou dans une méthode qui compare deux objets et que l'on souhaite s'assurer que les objets fournis implémentent l'interface
        Comparable.

        Pour cela, il faut utiliser des paramètres de type bornés (bounded type parameters) qui permettent de définir des restrictions
        sur le type qui sera autorisé à être utilisé comme type paramétré.

        Les paramètres de type bornés peuvent être utilisés dans la définition des types et des méthodes génériques. Ils permettent de
        restreindre les types utilisables avec une classe ou une méthode générique tout en ayant la flexibilité de travailler avec les
        différents types définis dans le générique.

        Pour déclarer un paramètre de type borné, il faut indiquer le nom du paramètre de type, suivi du mot-clé extends, suivi du type
        qui représente sa borne supérieure.

        Dans ce contexte, le mot clé extends indique que le type étend la borne supérieure dans le cas d'une classe ou implémente une borne
        supérieure dans le cas d'une interface. Exemple : <T extends Number>

        T pourra être le type Number ou une de ses classes filles lors de la déclaration d'une type paramétré.

        Il est possible de préciser une relation entre une variable de type et une classe ou une interface : ainsi, avec le mot-clé extends
        dans la variable de type, il sera possible d'utiliser une instance du type paramétré avec n'importe quel objet qui hérite ou implémente
        la classe ou l'interface précisée.
     */

    public static <T extends Comparable<T>> T max(T x, T y) {
        T max = x;
        if(y.compareTo(max) > 0) {
            max = y;
        }
        return max;
    }

    public static void main(String... args) {
        System.out.println(MaClasse3.max(123, 26));
        System.out.println(MaClasse3.max("abc", "xyz"));
        System.out.println(MaClasse3.<Integer>max(123, 26));
        System.out.println(MaClasse3.<String>max("abc", "xyz"));
    }
}

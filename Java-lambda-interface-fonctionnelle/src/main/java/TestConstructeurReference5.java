public class TestConstructeurReference5 {
    /*
        Il est possible d'invoquer un constructeur possédant des paramètres :
        il faut pour cela que la méthode de l'interface fonctionnelle possède
        les paramètres qui correspondent à ceux du constructeur invoqué.
     */
    public static void main(String[] args) {
        IntegerSupplier supplier = (int value) -> Integer.valueOf(value);
        Integer myInteger = supplier.creerInstance(100);
        System.out.println(myInteger);
    }
}
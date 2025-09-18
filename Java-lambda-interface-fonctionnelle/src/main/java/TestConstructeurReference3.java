import java.util.function.Supplier;

public class TestConstructeurReference3 {
    /*
        Il est possible d'invoquer un constructeur possédant des paramètres :
        il faut pour cela que la méthode de l'interface fonctionnelle possède
        les paramètres qui correspondent à ceux du constructeur invoqué.
     */
    public static void main(String[] args) {
        PersonneSupplier supplier = Personne::new;
        Personne personne = supplier.creerInstance("nom1", "prenom1");
        System.out.println(personne);
    }
}
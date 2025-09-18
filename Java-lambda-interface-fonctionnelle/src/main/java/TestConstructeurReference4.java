public class TestConstructeurReference4 {
    /*
        Cet exemple utilise une expression lambda.
        Il est équivalent à TestConstructeurReference3
     */
    public static void main(String[] args) {
        PersonneSupplier supplier = (nom, prenom) -> new Personne(nom, prenom);
        Personne personne = supplier.creerInstance("nom1", "prenom1");
        System.out.println(personne);
    }
}
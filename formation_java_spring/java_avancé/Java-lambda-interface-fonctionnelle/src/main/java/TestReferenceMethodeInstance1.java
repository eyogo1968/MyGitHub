import java.util.Arrays;

public class TestReferenceMethodeInstance1 {

    public static void main(String[] args) {
        Personne[] personnes = {
                new Personne("nom3", "Julien"),
                new Personne("nom1", "Thierry"),
                new Personne("nom2", "Alain")
        };
        ComparaisonPersonne1 comparaisonPersonne = new ComparaisonPersonne1();

        Arrays.sort(personnes, comparaisonPersonne::comparerParNom);
        System.out.println(Arrays.deepToString(personnes));

        Arrays.sort(personnes, comparaisonPersonne::comparerParPrenom);
        System.out.println(Arrays.deepToString(personnes));
    }
}

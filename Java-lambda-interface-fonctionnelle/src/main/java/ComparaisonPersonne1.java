public class ComparaisonPersonne1 {

    public int comparerParNom(Personne p1, Personne p2) {
        return p1.getNom().compareTo(p2.getNom());
    }

    public int comparerParPrenom(Personne p1, Personne p2) {
        return p1.getPrenom().compareTo(p2.getPrenom());
    }
}

@FunctionalInterface
public interface PersonneSupplier {
    Personne creerInstance(String nom, String prenom);
}
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Tâche 1 : Types primitifs
        int age = 25;
        double prix = 19.99;
        char lettre = 'J';
        boolean actif = true;

        System.out.println("Age: " + age);
        System.out.println("Prix: " + prix);
        System.out.println("Lettre: " + lettre);
        System.out.println("Actif: " + actif);

        // Tâche 2 : Chaînes de caractères
        String message = "Bonjour";
        message += " Java";
        System.out.println("String: " + message);

        StringBuilder sb = new StringBuilder("Bonjour");
        sb.append(" Java");
        System.out.println("StringBuilder: " + sb);

        // Tâche 3 : Tableaux
        int[] tableau = {10, 20, 30, 40, 50};
        for (int i = 0; i < tableau.length; i++) {
            System.out.println("Élément " + i + ": " + tableau[i]);
        }

        // Tâche 4 : Listes dynamiques (ArrayList)
        ArrayList<String> prenoms = new ArrayList<>();
        prenoms.add("Alice");
        prenoms.add("Bob");
        prenoms.add("Charlie");
        System.out.println("Taille de la liste: " + prenoms.size());
        System.out.println("Contenu: " + prenoms);

        // Tâche 5 : Ensembles (HashSet)
        HashSet<String> noms = new HashSet<>();
        noms.add("Alice");
        noms.add("Bob");
        noms.add("Alice"); // doublon
        System.out.println("HashSet: " + noms);

        // Tâche 6 : Enumérations
        Jour jour = Jour.MERCREDI;
        System.out.println("Jour de la semaine: " + jour);

        switch (jour) {
            case LUNDI -> System.out.println("Courage, c'est lundi !");
            case MERCREDI -> System.out.println("C'est le milieu de la semaine.");
            case VENDREDI -> System.out.println("C'est bientôt le week-end !");
            default -> System.out.println("Jour normal.");
        }
    }

    enum Jour {
        LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE
    }
}
public class MaClasse1 {
/*
    La syntaxe de définition d'une méthode générique doit suivre plusieurs règles :

    toutes les déclarations de méthodes génériques comportent une section de
    définition de type paramétré délimitée par une paire < et > qui précède le
    type de retour de la méthode

    chaque section de type paramétré contient un ou plusieurs types paramétrés
    séparés par des virgules.

    Un type paramétré est un identifiant qui spécifie un nom de type générique.

    Un type paramétré ne peut pas être un type primitif les types paramétrés
    peuvent être utilisés pour déclarer le type de retour et le type des paramètres
 */

    public static <E> void afficher( E[] donnees ) {
        for(E element : donnees) {
            System.out.print(element);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Integer[] entiers = { 1, 2, 3, 4, 5 };
        String[] chaines = { "a", "b", "c", "d", "e" };

        afficher(entiers);
        afficher(chaines);
    }
}

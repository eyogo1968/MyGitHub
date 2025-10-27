public class MaClasse4 {
    /*
        Un autre exemple : restreindre le type d'objets qui peut être utilisé dans le type
        paramétré dans une méthode qui compare deux objets pour assurer que les objets
        acceptés implémentent l'interface Comparable.
     */
    public static <T extends Comparable<T>> int comparer(T t1, T t2){
        return t1.compareTo(t2);
    }
}

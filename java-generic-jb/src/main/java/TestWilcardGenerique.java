import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TestWilcardGenerique {

    /*
        Il n'est pas possible de passer en paramètre de cette méthode,
        une List<Carre> ou List<Triangle> même si Carre et Triangle sont
        des classes filles de Forme.
     */
    public static void dessinerToutes1(List<Forme> formes) {
        for(Forme f : formes) {
            f.dessiner();
        }
    }

    /*
       Pour permettre cela, il faut utiliser un wildcard avec une borne supérieure.
       Cela permet de passer en paramètre une List<Forme> mais aussi une List dont
       l'argument de type est un sous-type de Forme.
     */
    public static void dessinerToutes2(List<? extends Forme> formes) {
        for(Forme f : formes) {
            f.dessiner();
        }
    }

    public static void main(String[] args) {
        List<Forme> formes = new ArrayList<Forme>();
        Forme forme1 = new Forme("forme");
        formes.add(forme1);
        dessinerToutes1(formes);

        List<Carre> carres = new ArrayList<Carre>();
        Carre carre1 = new Carre("carre");
        carres.add(carre1);
        dessinerToutes2(carres);

        List<Rectangle> rectangles = new ArrayList<Rectangle>();
        Rectangle rectangle1 = new Rectangle("rectangle");
        rectangles.add(rectangle1);
        dessinerToutes2(rectangles);

    }
}

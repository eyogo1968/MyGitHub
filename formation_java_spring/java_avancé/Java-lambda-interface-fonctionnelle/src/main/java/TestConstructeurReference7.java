import java.util.ArrayList;
import java.util.List;

public class TestConstructeurReference7 {

    public static void main(String[] args) {
        MaFabrique2<Integer[]> fabrique = Integer[]::new;
        Integer[] entiers = fabrique.creerInstance(10);
        System.out.println("taille = "+entiers.length);
    }
}
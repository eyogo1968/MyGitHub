import java.util.ArrayList;
import java.util.List;

public class TestConstructeurReference6 {

    public static void main(String[] args) {
        MaFabrique1<List<String>> fabrique = ArrayList<String>::new;
        List<String> list = fabrique.creerInstance();
    }
}
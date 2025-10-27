import java.util.ArrayList;
import java.util.TreeSet;

public class TestClasseGenerique2 {
    public static void main(String[] args) {
        MaClasseGenerique2<ArrayList> maClasseA =
                new MaClasseGenerique2<ArrayList>(new ArrayList());
        MaClasseGenerique2<TreeSet> maClasseB =
                new MaClasseGenerique2<TreeSet>(new TreeSet());
    }
}

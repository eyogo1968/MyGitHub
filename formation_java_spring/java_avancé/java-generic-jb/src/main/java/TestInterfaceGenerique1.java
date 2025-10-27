public class TestInterfaceGenerique1 {

    public static void main(String[] args) {
        InterfaceGenerique1<Integer> op = new InterfaceGenerique1<>() {
            public Integer ajouter(Integer a, Integer b) {
                return a+b;
            }
        };
        Integer myOP = op.ajouter(10, 5);
        System.out.println(myOP);
    }
}
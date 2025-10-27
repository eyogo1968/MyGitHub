public class TestMaClasseGenerique1 {
    public static void main(String[] args) {
        MaClasseGenerique1<Integer, String> maClasse =
                new MaClasseGenerique1<Integer, String>(1, "valeur 1");
        Integer param1 = maClasse.getParam1();
        String  param2 = maClasse.getParam2();

        System.out.println(param1);
        System.out.println(param2);
    }
}

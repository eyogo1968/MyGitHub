public class TestMonInterface2 {

    public static void executer(MonInterfaceFonctionnelle monInterface) {
        monInterface.executer();
    }

    public static void main(String[] args) {
        executer(() -> System.out.println("test"));
    }
}
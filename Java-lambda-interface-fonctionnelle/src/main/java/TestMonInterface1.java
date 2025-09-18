public class TestMonInterface1 {

    public static void executer(MonInterfaceFonctionnelle monInterface) {
        monInterface.executer();
    }

    public static void main(String[] args) {
        executer(new MonInterfaceFonctionnelle() {

            @Override
            public void executer() {
                System.out.println("test");
            }
        });
    }
}
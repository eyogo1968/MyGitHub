public class Calculatrice {

    @FunctionalInterface
    interface OperationEntiere {
        String  effectuer(int a, int b);
    }

    public String calculer(int a, int b, OperationEntiere operation) {
        return operation.effectuer(a, b);
    }

    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();
        OperationEntiere addition = (a, b) -> "addition = " + (a + b);
        OperationEntiere soustraction = (a, b) -> "soustraction = "+ (a - b);

        System.out.println(calc.calculer(10, 5, addition));
        System.out.println(calc.calculer(10, 5, soustraction));
    }
}

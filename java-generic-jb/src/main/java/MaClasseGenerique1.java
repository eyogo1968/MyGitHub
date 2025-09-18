public class MaClasseGenerique1<T1, T2> {
    private T1 param1;
    private T2 param2;

    public MaClasseGenerique1(T1 param1, T2 param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public T1 getParam1() {
        return this.param1;
    }

    public T2 getParam2() {
        return this.param2;
    }
}
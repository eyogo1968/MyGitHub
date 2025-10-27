import java.util.Collection;

public class MaClasseGenerique2<T extends Collection> {
    private T param;

  public MaClasseGenerique2(T param) {
        this.param = param;
    }

    public T getParam() {
        return this.param;
    }
}
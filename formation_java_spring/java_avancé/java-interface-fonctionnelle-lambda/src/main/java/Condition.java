@FunctionalInterface
interface Condition<T> {
    boolean test(T t);
}
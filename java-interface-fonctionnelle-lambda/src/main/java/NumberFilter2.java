import java.util.List;

class NumberFilter2{
    static List<Integer> filter(List<Integer> numbers, Condition<Integer> condition) {
        return numbers.stream()
                .filter(condition::test)
                .toList();
    }
}

import java.util.ArrayList;
import java.util.List;

class NumberFilter1 {
    static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }
}
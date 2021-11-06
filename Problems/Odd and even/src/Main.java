import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Utils {

    public static List<Integer> sortOddEven(List<Integer> numbers) {
        List<Integer> odd = numbers.stream()
                .filter(i -> i % 2 != 0)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> even = numbers.stream()
                .filter(i -> i % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        odd.addAll(even);

        return odd;
    }
}


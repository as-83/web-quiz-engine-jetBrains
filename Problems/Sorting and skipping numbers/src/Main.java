import java.util.*;
import java.util.stream.Collectors;

class ProcessNumbers {

    public static List<Integer> processNumbers(Collection<Integer> numbers) {
        return numbers.stream().sorted()
                .dropWhile(i -> i < 10)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));

        String result = processNumbers(numbers).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}

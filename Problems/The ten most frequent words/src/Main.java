import java.util.*;
import java.util.stream.Collectors;

// Not this task !!!
public class Main {
    public static void main(String[] args) {
        Arrays.stream(new Scanner("Functions bring happiness!").nextLine()
        .split("(?:(?<=^|[^a-zA-Z])'|'(?=[^a-zA-Z]|$)|[^a-zA-Z'])+"))
        .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
        .entrySet().stream()
                .sorted(Comparator.comparing)
                .forEach(System.out::println);
        /*Map<String, Long> values = Arrays.stream(new Scanner(System.in).nextLine()
                .split("(?:(?<=^|[^a-zA-Z])'|'(?=[^a-zA-Z]|$)|[^a-zA-Z'])+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));*/



    }
}

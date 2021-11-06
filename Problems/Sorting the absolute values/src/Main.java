import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    /**
     * Returns the sorted array of absolute numbers in ascending order.
     *
     * @param numbers the input array of String integer numbers
     * @return the sorted array of integer absolute numbers
     */
    public static int[] sortedAbsNumbers(String[] numbers) {
        int[] result = new int[numbers.length];
        int[] j = new int[1];
        j[0] = 0;
        Arrays.stream(numbers).mapToInt(str -> Math.abs(Integer.parseInt(str)))
                  .sorted()
                  .forEach(i -> result[j[0]++] = i);
       return result;
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.stream(sortedAbsNumbers(scanner.nextLine().split("\\s+")))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );


    }
}

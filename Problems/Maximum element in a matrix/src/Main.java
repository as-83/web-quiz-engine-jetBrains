import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int[] matrixSize = parseInputLine(scanner);

        final int[][] numbers = new int[matrixSize[0]][matrixSize[1]];
        for (int i = 0; i < matrixSize[0]; i++) {
            numbers[i] = parseInputLine(scanner);
        }
        searchIndexOfInitialAppearance(numbers);
    }

    private static void searchIndexOfInitialAppearance(int[][] numbers) {
        int maxValue = Integer.MIN_VALUE;
        int[] index = {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] > maxValue) {
                    maxValue = numbers[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        System.out.println(index[0] +  " " + index[1]);
    }

    private static int[] parseInputLine(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

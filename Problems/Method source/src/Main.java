import java.util.Arrays;
import java.util.stream.IntStream;

class TestHelper {
    public static int[] primeGenerator() {
        return IntStream.iterate(10, i -> i + 1)
                .limit(991)
                .filter(MyUtils::isPrimeIn10To1000)
                .limit(40)
                .toArray();
    }
}


class MyUtils {
    public static boolean isPrimeIn10To1000(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


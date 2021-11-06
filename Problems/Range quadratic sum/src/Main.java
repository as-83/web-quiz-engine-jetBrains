import java.util.stream.*;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        return IntStream.iterate(fromIncl, i -> i + 1)
                .limit(toExcl - fromIncl)
                .map(v -> v * v )
                .sum();
    }
}

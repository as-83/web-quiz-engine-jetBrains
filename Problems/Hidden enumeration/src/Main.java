import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                Arrays.stream(Secret.values()).filter(v -> v.toString().startsWith("STAR"))
                        .count()
        );
    }
}


/*
enum Secret {
    STAR, CRASH, START // ...
}
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        set.addAll(List.of( "Gamma", "Alpha", "Omega"));
        System.out.println(set);
    }
}

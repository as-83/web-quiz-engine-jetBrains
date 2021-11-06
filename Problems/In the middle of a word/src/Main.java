import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile(".*[a-z]+" + part.toLowerCase() + "[a-z]+.*");
        Matcher matcher = pattern.matcher(line.toLowerCase());
        System.out.println(matcher.matches() ? "YES" : "NO");
    }
}

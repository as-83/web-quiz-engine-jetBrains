import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine().trim();
        String line = scanner.nextLine().trim();

        Pattern pattern = Pattern.compile("([a-z]+" + part + "\\b)" +
                "|(\\b" + part + "[a-z]+)" +
                "|(\\b" + part + "\\b)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        System.out.println(matcher.find()? "YES" : "NO");
    }
}

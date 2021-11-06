import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(" +
                "((2[0-4]\\d)" +
                "|(25[0-5])|(1\\d{2})" +
                "|([1-9]?\\d))\\." +
                "){3}" +
                "((2[0-4]\\d)|(25[0-5])|(1\\d{2})|([1-9]?\\d))";

        String ip = scanner.nextLine();
        System.out.println(ip.matches(regex) ? "YES" : "NO");
    }
}

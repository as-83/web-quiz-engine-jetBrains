import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int passwordMinLength = 12;

        String upperRegex = "\\w*[A-Z]+\\w*";
        String lowerRegex = "\\w*[a-z]+\\w*";
        String digitRegex = "\\w*[0-9]+\\w*";

        String password = scanner.nextLine();
        boolean isHard = false;

        if (password.length() >= passwordMinLength) {
            isHard = password.matches(upperRegex)
                    && password.matches(lowerRegex)
                    && password.matches(digitRegex);
        }
        System.out.println(isHard ? "YES" : "NO");
    }
}

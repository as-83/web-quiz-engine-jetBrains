import java.util.Comparator;
import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Utils {

    public static void sortUsers(List<User> users) {
        // your code here
        users.sort(Comparator.comparing(User::getName).thenComparing((u1, u2) -> u2.getAge() - u1.getAge()));
    }
}

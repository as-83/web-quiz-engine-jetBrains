import java.util.List;

class Utils {

    public static void sortStrings(List<String> strings) {
        // your code here
        strings.sort((s1, s2) -> s2.compareTo(s1));
    }

}

/*public class Main {
    public static void main(String[] args) {
        List<String> list = Stream.of("apple", "grape", "pear", "banana", "pineapple").collect(Collectors.toList());
        Utils.sortStrings(list);
        list.forEach(System.out::println);
    }
}*/

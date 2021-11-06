import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        for (String str : strings) {
            if (!sortedMap.containsKey(str)) {
                sortedMap.put(str, 1);
            } else {
                sortedMap.put(str, sortedMap.get(str) + 1);
            }
        }
        return sortedMap;
    }

    public static void printMap(Map<String, Integer> map) {
        for (String str: map.keySet()) {
            System.out.println(str + " : " + map.get(str));
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}

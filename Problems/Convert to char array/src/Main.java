import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        charArrayWriter.write(Arrays.stream(words).collect(Collectors.joining()));
        return  charArrayWriter.toCharArray();
    }
}

/*public  class Main {
    public static void main(String[] args) {
        String[] strings = {"This", " ", "is", " ", "a", " ", "test"};
        char[] chars = {};
        try {
            chars =  Converter.convert(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (char ch:
             chars) {
            System.out.print(ch + " ");
        }
    }
}*/

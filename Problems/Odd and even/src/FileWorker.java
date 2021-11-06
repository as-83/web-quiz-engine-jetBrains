import java.io.File;
import java.io.IOException;

public class FileWorker {
    public static void main(String[] args) {
        File file = new File("D:\\sul\\file.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File dir = new File("D:\\sul\\file");
        if (dir.mkdir()) {
            System.out.println("Created");
        } else {
            System.out.println("Dir already exists");
        }

        if (dir.delete()) {
            System.out.println("Deleted");
        } else {
            System.out.println("Doesn't exists");
        }

        



    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HowToProcessFile {
    public static String setFile(String filename) {
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filename) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;

    }

    public static void main(String[] args) {
        String path2 = "/Users/liloli/Desktop/3134DataStructure/hw2/test2.txt";
        String path="/Users/liloli/Desktop/3134DataStructure/hw2/TestFiles/Test1.java";
        String p = setFile(path);
        System.out.print(p);
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class SymbolBalance implements SymbolBalanceInterface {
    private String content = "";
    public void setFile(String filename) {
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filename) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public BalanceError checkFile() {
        return null;
    }

}

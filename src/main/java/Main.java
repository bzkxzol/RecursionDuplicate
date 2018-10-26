import java.io.File;

public class Main {

    public static void main(String[] args) {
        DirectoryExplorer directoryExplorer = new DirectoryExplorer();
        directoryExplorer.findAllFiles(new File("."));
    }
}

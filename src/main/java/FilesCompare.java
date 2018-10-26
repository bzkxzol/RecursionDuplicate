import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FilesCompare {

    public boolean isFilesEquals(File file1, File file2){
        try {
            return FileUtils.contentEquals(file1,file2);
        } catch (IOException e) {
            e.getMessage();
        }
        return false;
    }
}

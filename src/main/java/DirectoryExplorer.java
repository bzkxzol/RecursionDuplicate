import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class DirectoryExplorer {

    public void findAllFiles(File dir) {

        FilesCompare filesCompare = new FilesCompare();
        File[] files = dir.listFiles();

        for (File file : files) {

            if (file.isDirectory()) {
                findAllFiles(file);
            }

            for (int i = 0; i < files.length; i++) {
                if (!file.getName().equals(files[i].getName())) {
                    if (filesCompare.isFilesEquals(file, files[i])) {
                        String newFileName = files[i].getAbsolutePath() + "_duplicated";
                        File renamedFile = new File(newFileName);
                        file.renameTo(renamedFile);
                        logAllDuplicates("File: " + file.getName() + " was renamed to: " + renamedFile.getName() + "\n");
                    }
                }
            }
        }
    }

    private void logAllDuplicates(String textToWrite){
        BufferedWriter writer = null;
        try {
            File log = new File("duplicates_log.txt");
            writer = new BufferedWriter(new FileWriter(log, true));
            writer.write(textToWrite);
        }catch (Exception e){
            e.getMessage();
        }finally {
            try{
                writer.close();
            }catch (Exception e){
            }
        }
    }
}

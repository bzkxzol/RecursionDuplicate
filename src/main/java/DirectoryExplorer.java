import java.io.File;


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
                        file.renameTo(new File(files[i].getAbsolutePath() + "_duplicated"));
                    }
                }
            }
        }
    }
}

import java.io.File;


public class DirectoryExplorer {

    public void findAllFiles(File dir){
        FilesCompare filesCompare = new FilesCompare();
        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
           if (files[i].isDirectory()){
               findAllFiles(files[i]);
           }else {
               for (File f : files){
                   if(filesCompare.isFilesEquals(f, files[i])){
                       f.renameTo(new File(files[i].getName() + "_duplicated"));
                   }else{

                   }
               }
           }
        }
    }
}

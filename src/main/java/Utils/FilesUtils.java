package Utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FilesUtils {

    public static void deleteFiles(File path) {
        try {
            FileUtils.cleanDirectory(path);
        }catch (IOException e) {
          Log.error(e.getMessage());
        }}


}

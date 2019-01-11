import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {


    public String name= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            + "/passguard/";

    private File dir;

    public void createFile() throws IOException {
        dir = new File(name);
        dir.mkdirs();
        File fileExt = new File(dir, "PassGuard.txt");
        fileExt.getParentFile().mkdirs();
        FileOutputStream fosExt = null;
        fosExt = new FileOutputStream(fileExt);
        fosExt.write("".getBytes());
        fosExt.close();
    }





}

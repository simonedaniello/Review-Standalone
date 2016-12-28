package control;

import java.io.*;
import java.util.UUID;

/**
 * @author dandi on 28/12/16.
 */

public class ImageController {

    private int errors = 0;

    void copyFile(File fileToCopy) throws IOException {
        String hashString = hashGenerator();
        if (hashString != null)
        {
            File copyOfTheFile = new File(hashString);

            InputStream inStream;
            OutputStream outStream;

            inStream = new FileInputStream(fileToCopy);
            outStream = new FileOutputStream(copyOfTheFile);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            inStream.close();
            outStream.close();
        }
    }

    private String hashGenerator(){
        if(errors > 5){
            return null;
        }
        else {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            File file = new File(uuid);
            if (file.exists()) {
                errors = 0;
                return uuid;
            } else
                errors++;
            return (hashGenerator());
        }
    }
}

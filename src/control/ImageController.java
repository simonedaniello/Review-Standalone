package control;

import java.io.*;
import java.util.UUID;

/**
 * @author dandi on 28/12/16.
 */

public class ImageController {

    private static ImageController instance = new ImageController();
    private int errors = 0;

    public boolean copyFile(File fileToCopy) throws IOException {
        String hashString = hashGenerator();
        if (hashString != null)
        {
            File copyOfTheFile = new File(hashString);
            if(!copyOfTheFile.createNewFile()){
                System.out.println("error on create file");
            }
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
            return true;
        }
        else
            System.out.println("il valore della stringa era null");
            return false;
    }

    private String hashGenerator() throws IOException {
        if(errors > 5){
            return null;
        }
        else {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            uuid = uuid + ".png";
            uuid = "src/images/" + uuid;
            File file = new File(uuid);
            if (!file.exists()) {
                errors = 0;
                System.out.println(uuid);
                return uuid;
            } else {
                errors++;
                System.out.println(uuid);
                return (hashGenerator());
            }
        }
    }

    public static ImageController getInstance(){
        return instance;
    }

    private ImageController(){}
}

package GENERICS.JAVA_STREAMS;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("original.jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageData = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
                FileOutputStream fos = new FileOutputStream("copy.jpg")) {
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


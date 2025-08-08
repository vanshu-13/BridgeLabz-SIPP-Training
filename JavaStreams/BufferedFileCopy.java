package GENERICS.JAVA_STREAMS;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourcePath = "largefile.dat";
        String destPath = "largefile_copy.dat";

        // Buffered
        long startBuffered = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long endBuffered = System.nanoTime();
        System.out.println("Buffered copy time: " + (endBuffered - startBuffered) + " ns");
    }
}


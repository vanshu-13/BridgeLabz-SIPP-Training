package challengeProblem;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class LargeFileWordCount {
    public static void main(String[] args) {
        String filename = "largefile.txt";
        long startTime = System.currentTimeMillis();
        long wordCount = 0;

        try (FileInputStream fis = new FileInputStream(filename);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (words.length == 1 && words[0].isEmpty()) {
                    continue;
                }
                wordCount += words.length;
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Total words in file: " + wordCount);
        System.out.println("Time taken to read and count: " + (endTime - startTime) + " ms");
    }
}
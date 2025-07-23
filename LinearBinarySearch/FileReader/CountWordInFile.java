package fileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {
    public static void main(String[] args) {
        String filename = "user_input.txt";
        String targetWord = "hello";

        int count = 0;

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            System.out.println("The word '" + targetWord + "' occurs " + count + " times in the file.");
        } catch (IOException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
}
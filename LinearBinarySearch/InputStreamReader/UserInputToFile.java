package inputStreamReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserInputToFile {
    public static void main(String[] args) {
        String filename = "user_input.txt";

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filename, true)) {

            String inputLine;
            System.out.println("Enter text to save to the file (type 'exit' to stop):");
            while (true) {
                inputLine = br.readLine();
                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(inputLine + "\n");
            }

            System.out.println("Input has been saved to " + filename);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
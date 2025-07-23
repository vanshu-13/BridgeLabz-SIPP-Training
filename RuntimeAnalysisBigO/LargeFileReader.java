package runtimeAnalysis;

import java.io.*;

public class LargeFileReader {
	
	public static void generateLargeFile(String filename, int sizeInMB) throws IOException {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
	        String line = "This is a line of sample text.\n";
	        int targetSize = sizeInMB * 1024 * 1024; // bytes
	        int currentSize = 0;
	        while (currentSize < targetSize) {
	            writer.write(line);
	            currentSize += line.getBytes().length;
	        }
	    }
	}
	
    public static void main(String[] args) throws IOException {
    	generateLargeFile("large_test_file.txt", 2);
        String filePath = "large_test_file.txt"; // Path to your large file
    
        // Measure FileReader (Character Stream)
        long startFileReader = 0, endFileReader = 0;
        try (FileReader fr = new FileReader(filePath)) {
            long totalChars = 0;
            int ch;
            startFileReader = System.currentTimeMillis();
            while ((ch = fr.read()) != -1) {
                totalChars++;
                // Optionally process ch
            }
            endFileReader = System.currentTimeMillis();
            System.out.println("FileReader read characters: " + totalChars);
        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        }
        System.out.println("FileReader Time: " + (endFileReader - startFileReader) + " ms");
        
        // Measure InputStreamReader (Byte Stream)
        long startInputStream = 0, endInputStream = 0;
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis)) {
            int ch;
            long totalChars = 0;
            startInputStream = System.currentTimeMillis();
            while ((ch = isr.read()) != -1) {
                totalChars++;
                // Optionally process ch
            }
            endInputStream = System.currentTimeMillis();
            System.out.println("InputStreamReader read characters: " + totalChars);
        } catch (IOException e) {
            System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        System.out.println("InputStreamReader Time: " + (endInputStream - startInputStream) + " ms");
    }
}
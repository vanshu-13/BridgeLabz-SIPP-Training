import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
	    public static void main(String[] args) {
	        try {
	            FileReader fr = new FileReader("data.txt");
	            int i;
	            while ((i = fr.read()) != -1) {
	                System.out.print((char) i);
	            }
	            fr.close();
	        } catch (IOException e) {
	            System.out.println("File not found");
	        }
	    }
}


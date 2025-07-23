package fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineByLine {

	public static void main(String args[]) {
		String fileName = "user_input.txt";
		
		try(FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)){
			
			String line;
			while((line = br.readLine()) !=null ) {
				System.out.println(line);
			}
		}catch(IOException e) {
			System.out.println("Error -> "+e.getMessage());
		}
	}
}
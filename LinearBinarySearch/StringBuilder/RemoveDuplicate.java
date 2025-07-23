package stringBuilder;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
	
	public static void main(String args[]) {
		StringBuilder sb = new StringBuilder();
		String str = "Hello World";
		Set<Character> set = new HashSet<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(!set.contains(ch)) {
				set.add(ch);
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}
}
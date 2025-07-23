package stringBuffer;

public class StringConcatenation {

	public static void main(String args[]) {
		String[] strArray = {"Hello", " ", "World","!"};
		
		String result = concateString(strArray);
		System.out.println(result);
	}
	
	public static String concateString(String[] strArray) {
		
		StringBuffer sb = new StringBuffer();
		
		for(String s : strArray) {
			sb.append(s);
		}
		
		return sb.toString();
	}
}
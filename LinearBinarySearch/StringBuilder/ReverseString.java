package stringBuilder;

public class ReverseString {

	public static void main(String args[]) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello");
		sb.reverse();
		System.out.println(sb.toString());
	}
}
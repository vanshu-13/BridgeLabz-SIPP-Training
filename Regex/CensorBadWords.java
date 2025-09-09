
public class CensorBadWords {
	    public static String censor(String text, String[] badWords) {
	        for (String bad : badWords) {
	            text = text.replaceAll("(?i)\\b" + bad + "\\b", "****");
	        }
	        return text;
	    }

	    public static void main(String[] args) {
	        String[] badWords = {"damn", "stupid"};
	        String sentence = "This is a damn bad example with some stupid words.";
	        System.out.println(censor(sentence, badWords));
	    }
	
}

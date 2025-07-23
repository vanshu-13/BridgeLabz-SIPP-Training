package linearSearch;

public class SearchWordInSentence {

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (containsWord(sentence, word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    private static boolean containsWord(String sentence, String word) {
    	String[] words = sentence.trim().split("\\W+");
    	for(String s: words) {
    		if(s.equalsIgnoreCase(word)) {
    			return true;
    		}
    	}
    	return false;
    }

    public static void main(String[] args) {
        String[] sentences = {
            "This is the first sentence.",
            "Here is another one.",
            "The quick brown fox jumps over the lazy dog.",
            "Searching for the specific word.",
            "Final sentence."
        };

        String wordToFind = "searching";

        String result = findSentenceWithWord(sentences, wordToFind);
        System.out.println(result);
    }
}
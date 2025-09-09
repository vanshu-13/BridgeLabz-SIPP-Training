import java.util.regex.*;
import java.util.*;

public class ExtractCapitalizedWords {
    public static List<String> getCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher m = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(text);
        while (m.find()) words.add(m.group());
        return words;
    }

    public static void main(String[] args) {
        String sentence = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        System.out.println(getCapitalizedWords(sentence));
    }
}
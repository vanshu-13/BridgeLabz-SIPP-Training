import java.util.regex.*;
import java.util.*;

public class ExtractUrl {
    public static List<String> getURLs(String text) {
        List<String> urls = new ArrayList<>();
        Matcher m = Pattern.compile("https?://\\S+").matcher(text);
        while (m.find()) urls.add(m.group());
        return urls;
    }

    public static void main(String[] args) {
        String text = "Visit https://example.com or http://test.org for info.";
        System.out.println(getURLs(text));
    }
}
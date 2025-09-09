import java.util.regex.*;
import java.util.*;

public class ExtractEmails {
    public static List<String> getEmails(String text) {
        List<String> emails = new ArrayList<>();
        Matcher m = Pattern.compile("\\b[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}\\b").matcher(text);
        while (m.find()) emails.add(m.group());
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        System.out.println(getEmails(text));
    }
}
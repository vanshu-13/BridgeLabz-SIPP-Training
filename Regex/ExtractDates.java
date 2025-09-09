import java.util.regex.*;
import java.util.*;

public class ExtractDates {
    public static List<String> getDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher m = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        while (m.find()) dates.add(m.group());
        return dates;
    }

    public static void main(String[] args) {
        String text = "Important dates: 12/05/2023, 01/01/2024.";
        System.out.println(getDates(text));
    }
}
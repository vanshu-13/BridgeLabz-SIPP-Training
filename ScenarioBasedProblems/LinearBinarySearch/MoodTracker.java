package LinearBinarySearch;

import java.time.LocalDate;
import java.util.*;

public class MoodTracker {
    private HashMap<LocalDate, List<String>> moodMap;

    public MoodTracker() {
        moodMap = new HashMap<>();
    }

    public void logMood(LocalDate date, String mood) {
        moodMap.computeIfAbsent(date, k -> new ArrayList<>()).add(mood);
    }

    public List<LocalDate> getLast30Days() {
        List<LocalDate> last30Days = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 30; i++) {
            last30Days.add(today.minusDays(i));
        }
        return last30Days;
    }

    public int countMoodOccurrences(String targetMood, boolean displayDates) {
        List<LocalDate> last30Days = getLast30Days();
        int count = 0;

        System.out.println("Dates with '" + targetMood + "' in the last 30 days:");
        for (LocalDate date : last30Days) {
            List<String> moods = moodMap.get(date);
            if (moods != null) {
                for (String mood : moods) {
                    if (mood.equalsIgnoreCase(targetMood)) {
                        count++;
                        if (displayDates) {
                            System.out.println(date);
                        }
                        break;
                    }
                }
            }
        }
        return count;
    }

    public String analyzeSentiment(String mood) {
        if (mood.equalsIgnoreCase("happy") || mood.equalsIgnoreCase("excited")) {
            return "Positive sentiment";
        } else if (mood.equalsIgnoreCase("sad") || mood.equalsIgnoreCase("tired")) {
            return "Negative sentiment";
        } else {
            return "Neutral sentiment";
        }
    }

    public static void main(String[] args) {
        MoodTracker tracker = new MoodTracker();

        tracker.logMood(LocalDate.now().minusDays(1), "happy");
        tracker.logMood(LocalDate.now().minusDays(2), "sad");
        tracker.logMood(LocalDate.now().minusDays(3), "tired");
        tracker.logMood(LocalDate.now().minusDays(4), "happy");
        tracker.logMood(LocalDate.now().minusDays(5), "happy");
        tracker.logMood(LocalDate.now().minusDays(10), "sad");
        tracker.logMood(LocalDate.now().minusDays(15), "tired");
        tracker.logMood(LocalDate.now().minusDays(20), "happy");

        String moodToSearch = "happy";
        boolean showDates = true;
        int occurrences = tracker.countMoodOccurrences(moodToSearch, showDates);
        System.out.println("Total '" + moodToSearch + "' in last 30 days: " + occurrences);

        System.out.println("Sentiment for 'happy': " + tracker.analyzeSentiment("happy"));
    }
}
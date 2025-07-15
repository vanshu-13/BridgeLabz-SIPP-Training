
package browserHistoryNavigation;

public class MediaHistory extends BrowserHistory {
    public MediaHistory(String firstTrack) {
        super(firstTrack);
    }

    public void replayCurrentTrack() {
        System.out.println("Replaying: " + getCurrentPage());
    }
}

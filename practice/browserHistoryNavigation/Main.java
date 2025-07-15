
package browserHistoryNavigation;

public class Main {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("home.com");
        history.visit("page1.com");
        history.visit("page2.com");
        history.visit("page3.com");

        history.back(2);
        history.forward(1);

        System.out.println("Current page: " + history.getCurrentPage());

        MediaHistory media = new MediaHistory("track1.mp3");
        media.visit("track2.mp3");
        media.replayCurrentTrack();
        media.back(1);
        media.replayCurrentTrack();
    }
}

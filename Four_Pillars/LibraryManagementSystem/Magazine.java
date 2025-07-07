public class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan duration for magazines
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

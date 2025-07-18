package dailyTaskPlanner;

class Meeting extends Task {
    public Meeting(String description) {
        super(description);
    }

    @Override
    public void execute() {
        System.out.println("Executing Meeting: " + description);
    }
}
package dailyTaskPlanner;

class CodingSession extends Task {
    public CodingSession(String description) {
        super(description);
    }

    @Override
    public void execute() {
        System.out.println("Executing Coding Session: " + description);
    }
}
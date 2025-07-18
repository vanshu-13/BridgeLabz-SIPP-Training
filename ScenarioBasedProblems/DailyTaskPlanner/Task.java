package dailyTaskPlanner;


abstract class Task {
    protected String description;

    public Task(String description) {
        this.description = description;
    }

    public abstract void execute();

    public String getDescription() {
        return description;
    }
}
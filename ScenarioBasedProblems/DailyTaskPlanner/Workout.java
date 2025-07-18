package dailyTaskPlanner;

class Workout extends Task {
    public Workout(String description) {
        super(description);
    }

    @Override
    public void execute() {
        System.out.println("Executing Workout: " + description);
    }
}
package LambdaExpression;

// Lambda Expression Example 1: Smart Home Lighting Automation

public class SmartHomeLighting {
    public static void main(String[] args) {
        System.out.println("=== Smart Home Lighting Automation ===");

        Runnable motionTrigger = () -> System.out.println("Light ON: Motion detected!");
        Runnable timeOfDayTrigger = () -> System.out.println("Light ON: Evening mode activated!");
        Runnable voiceCommandTrigger = () -> System.out.println("Light ON: Voice command executed!");

        // Simulate triggers
        motionTrigger.run();
        timeOfDayTrigger.run();
        voiceCommandTrigger.run();
    }
}

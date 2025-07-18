package AutomatedIrrigationSystem;

public class AgricultureApp {
	 public static void main(String[] args) {
	     IrrigationUnit unit1 = new Sprinkler(1.2);
	     IrrigationUnit unit2 = new DripSystem(0.8);

	     unit1.prepare();
	     unit1.readSensorData();
	     unit1.startWatering();

	     System.out.println();

	     unit2.prepare();
	     unit2.readSensorData();
	     unit2.startWatering();
	 }
	}
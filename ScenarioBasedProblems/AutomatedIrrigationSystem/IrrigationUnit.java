package AutomatedIrrigationSystem;

abstract class IrrigationUnit implements SensorReadable {
	private double calibrationFactor;

	public IrrigationUnit() {
	    this.calibrationFactor = 1.0;
	}


	public IrrigationUnit(double calibrationFactor) {
	    this.calibrationFactor = calibrationFactor;
	}

	public void prepare() {
	    System.out.println("Preparing " + this.getClass().getSimpleName() + "...");
	    calibrate();
	}

	protected void calibrate() {
	    System.out.println("Calibrating with factor: " + calibrationFactor);
	}

	public abstract void startWatering();

	@Override
	public double readSensorData() {
	    double sensorData = Math.random() * 100;
	    System.out.println(this.getClass().getSimpleName() + " sensor data: " + sensorData);
	    return sensorData;
	}
}
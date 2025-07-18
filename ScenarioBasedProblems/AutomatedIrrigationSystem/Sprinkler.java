package AutomatedIrrigationSystem;

class Sprinkler extends IrrigationUnit {
	public Sprinkler() {
	    super();
	}

	public Sprinkler(double calibrationFactor) {
	    super(calibrationFactor);
	}

	@Override
	public void startWatering() {
	    System.out.println("Sprinkler is watering the field...");
	}

	@Override
	protected void calibrate() {
	    super.calibrate();
	    System.out.println("Sprinkler-specific calibration adjustments.");
	}
}
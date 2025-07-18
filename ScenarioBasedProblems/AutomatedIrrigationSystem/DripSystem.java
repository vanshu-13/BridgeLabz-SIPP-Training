package AutomatedIrrigationSystem;

class DripSystem extends IrrigationUnit {
	public DripSystem() {
		super();
	}

	public DripSystem(double calibrationFactor) {
	    super(calibrationFactor);
	}

	@Override
	public void startWatering() {
	    System.out.println("Drip system is delivering water...");
	}
}
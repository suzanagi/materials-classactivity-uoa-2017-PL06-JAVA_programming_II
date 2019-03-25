public class Car extends Vehicle {
	// Integer number of seats in a vehicle.
	private int numberOfSeats;
	// Boolean status of aircondition's working: ON/OFF.
	private boolean airConditionOn = false;
	
	/* Constructor */
	public Car(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int seatNum) {
		// Constructor of the super class
		super(modelName, company, owner, engineType, tankSize, fuelConsumption);
		/*
		// If the engine type is not Gasoline (By the conditions to write methods, The Car uses only gasoline engine)
		if(engineType != "Gasoline" && engineType != "gasoline") System.err.println("Illegal type of fuel has given: " + engineType + ". The Car uses only gasoline engine.");
		*/
		// Setting the seatNum of the vehicle
		this.numberOfSeats = seatNum;
	}
	
	/* Returns the string expression of this object */
	public String toString() {
		return super.toString() + ", NumberOfSeat: " + this.numberOfSeats;
	}
	
	@Override
	public double costFor100Km(PetroleumPrice price) {
			return 100 / this.getFuelConsumption() * price.getGasolineCost();
	}

	@Override
	public void setAirConditionOn() {
		this.setFuelConsumption(this.getFuelConsumption() * 0.85);
		this.airConditionOn = true;
	}

	@Override
	public void setAirConditionOff() {
		this.setFuelConsumptionAsDefault();
		this.airConditionOn = false;
	}

}

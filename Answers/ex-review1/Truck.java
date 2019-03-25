public class Truck extends Vehicle {
	// Integer number of seats in a vehicle.
	private int numberOfSeats;
	// Boolean status of aircondition's working: ON/OFF.
	private boolean airConditionOn = false;
	// Horse Power of a vehicles's engine.
	private int power = 0;
	
	/* Constructor */
	public Truck(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int seatNum, int power) {
		// Constructor of the super class
		super(modelName, company, owner, engineType, tankSize, fuelConsumption);
		// If the engine type is not Diesel (By the conditions to write methods, The Truck uses only diesel engine)
		if(engineType != "Diesel" && engineType != "diesel") System.err.println("Illegal type of fuel has given: " + engineType + ". The Truck uses only diesel engine.");
		// Setting the seatNum of the vehicle
		this.numberOfSeats = seatNum;
		// Setting the power of the Truck
		this.power = power;
	}
	
	/* Returns the string expression of this object */
	public String toString() {
		return super.toString() + ", NumberOfSeat: " + this.numberOfSeats + ", HorsePower: " + this.power;
	}
	
	/* Setting the number of seats of this Truck */
	public void setNumberOfSeat(int seatNum) {
		this.numberOfSeats = seatNum;
	}
	
	/* Setting the power of this Truck */
	public void setPower(int power) {
		this.power = power;
	}
	
	@Override
	public double costFor100Km(PetroleumPrice price) {
			return 100 / this.getFuelConsumption() * price.getDieselCost();
	}

	@Override
	public void setAirConditionOn() {
		this.setFuelConsumption(this.getFuelConsumption() * 0.75);
		this.airConditionOn = true;
	}

	@Override
	public void setAirConditionOff() {
		this.setFuelConsumptionAsDefault();
		this.airConditionOn = false;
	}

}

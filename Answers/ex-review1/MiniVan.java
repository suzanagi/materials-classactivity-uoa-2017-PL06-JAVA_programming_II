public class MiniVan extends Vehicle {
	// Integer number of seats in a vehicle.
	private int numberOfSeats;
	// Boolean status of aircondition's working: ON/OFF.
	private boolean airConditionOn = false;
	// Boolean status of a vehicle's having auto door.
	private boolean hasAutoDoor = false;
	
	/* Constructor */
	public MiniVan(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int seatNum, boolean hasAutoDoor) {
		// Constructor of the super class
		super(modelName, company, owner, engineType, tankSize, fuelConsumption);
		// If the engine type is not Diesel (By the conditions to write methods, The MiniVan uses only diesel engine)
		if(engineType != "Diesel" && engineType != "diesel" && engineType != "Gasoline" && engineType != "gasoline" && engineType != "Hybrid" && engineType != "hybrid") System.err.println("Illegal type of fuel has given: " + engineType + ". The MiniVan uses gasoline, diesel, or hybrid engine.");
		// Setting the seatNum of the vehicle
		this.numberOfSeats = seatNum;
		// Setting the hasAutoDoor of the vehicle
		this.hasAutoDoor = hasAutoDoor;
	}
	
	/* Returns the string expression of this object */
	public String toString() {
		return super.toString() + ", NumberOfSeat: " + this.numberOfSeats + ", HasAutoDoor: " + this.hasAutoDoor;
	}
	
	/* Setting the number of seat of this MiniVan */
	public void setNumberOfSeat(int seatNum) {
		this.numberOfSeats = seatNum;
	}
	
	/* Setting the setHasAutoDoor of this MiniVan */
	public void setHasAutoDoor(boolean has) {
		this.hasAutoDoor = has;
	}
	
	@Override
	public double costFor100Km(PetroleumPrice price) {
		
		// Check the fuel price (The engine type "Hybrid" uses only gasoline)
		double marketValue = 0.0;
		if(this.getEngineType() == "Gasoline" || this.getEngineType() == "gasoline") marketValue = price.getGasolineCost();
		else if(this.getEngineType() == "Diesel" || this.getEngineType() == "diesel") marketValue = price.getDieselCost();
		else if(this.getEngineType() == "Hybrid" || this.getEngineType() == "hybrid") marketValue = price.getGasolineCost();
		else System.err.println("Something wrong at the fuel price of MiniVan: " + this.getEngineType() + ". The engine type must be gasoline or diesel.");
		
		return 100 / this.getFuelConsumption() * marketValue;
		
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

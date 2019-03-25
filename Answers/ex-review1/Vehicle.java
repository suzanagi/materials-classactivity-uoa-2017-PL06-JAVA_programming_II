public abstract class Vehicle {
	// Model name of a vehicle
	private String modelName;
	// Company to produce the model
	private String company;
    // Owner of the vehicle
	private String owner;
    // Type of the engine. Classified by fuel type to be used such as gasoline, diesel, or hybrid
	private String engineType;
    // Size of fuel tank. Unit is liter.
	private double tankSize;
    // Fuel consumption. Unit is km/liter.
	private double fuelConsumption;
	// Initial Fuel consumption. Unit is km/liter.
	private final double originalFuelConsumption;

    /* Constructor */
    public Vehicle(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption) {
    		this.modelName = modelName;
    		this.company = company;
    		this.owner = owner;
    		this.setEngineType(engineType);
    		this.tankSize = tankSize;
    		this.fuelConsumption = fuelConsumption;
    		this.originalFuelConsumption = this.fuelConsumption;
    }
    
    /* Returns the string expression of this object */
    public String toString(){
    		String message = new String("ModelName: ");
    		message += this.modelName;
    		message += ", Company: ";
    		message += this.company;
    		message += ", Owner: ";
    		message += this.owner;
    		message += ", EngineType: ";
    		message += this.engineType;
    		message += ", TankSize: ";
    		message += this.tankSize;
    		message += ", FuelConsumption: ";
    		message += this.fuelConsumption;
        return message;
    }
    
    /* Getting information of movable distance of a vehicle when the tank of the vehicle is filled fully. */
    public double movableDistance() {
    		return this.tankSize * this.fuelConsumption;
    }
    
    /* Calculating cost for running 100Kms with the engine type and the petroleum price passed by as parameter. It will be different according to fuel and aircondition's status. */
    public abstract double costFor100Km(PetroleumPrice price);
    
    /* Setting the aircondition of the vehicle to ON. */
    public abstract void setAirConditionOn();
    
    /* Setting the aircondition of the vehicle to OFF. */
    public abstract void setAirConditionOff();
    
    /* Setting the model name of the vehicle */
    public void setModelName(String name) {
    		this.modelName = name;
    }
    
    /* Setting the company name of the vehicle */
    public void setCompanyName(String name) {
    		this.company = name;
    }
    
    /* Setting the owner of the vehicle */
    public void setOwner(String name) {
    		this.owner = name;
    }
    
    /* Setting the engine type of the vehicle */
    public void setEngineType(String type) {
    		if(type != "Gasoline" && type != "Diesel" && type != "Hybrid") throw new IllegalArgumentException("No such type of fuel: " + type);
    		else this.engineType = type;
    }
    
    /* Getting the engine type of the vehicle */
    public String getEngineType() {
    		return this.engineType;
    }
    
    /* Setting the tank size of the vehicle */
    public void setTankSize(double size) {
    		this.tankSize = size;
    }
    
    /* Setting the fuel consumption of the vehicle */
    public void setFuelConsumption(double consumption) {
    		this.fuelConsumption = consumption;
    }
    
    /* Setting the fuel consumption of the vehicle as a default */
    public void setFuelConsumptionAsDefault() {
    		this.fuelConsumption = this.originalFuelConsumption;
    }
    
    /* Getting the fuel consumption of the vehicle */
    public double getFuelConsumption() {
    		return this.fuelConsumption;
    }
}

public class PetroleumPrice {
	private double gasolinePrice;
    private double dieselPrice;

    public PetroleumPrice(double gasolinePrice, double dieselPrice){
	this.gasolinePrice = gasolinePrice;
	this.dieselPrice = dieselPrice;
    }

    public double getGasolineCost(){
	return this.gasolinePrice;
    }

    public double getDieselCost(){
	return this.dieselPrice;
    }
}

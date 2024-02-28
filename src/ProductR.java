
public class ProductR extends Product {

	/**
	 * This is the constructor it takes in a String double and char and assigns them to name price and type using the 
	 * superclass constructor
	 * 
	 * @param n The name
	 * @param p The price 
	 * @param t The type
	 */
	public ProductR(String n, double p, char t)
	{
		super(n, p, t);
	}
	
	/**
	 * This returns the total for R products just qty * getPrice();
	 * 
	 * @return total the price of the order
	 */
	public double total(int qty)
	{
		return qty * getPrice();
	}
}

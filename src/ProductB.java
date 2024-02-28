
public class ProductB extends Product {

	/**
	 * This is the constructor it takes in a String double and char and assigns them to name price and type using the 
	 * superclass constructor
	 * 
	 * @param n The name
	 * @param p The price 
	 * @param t The type
	 */
	public ProductB(String n, double p, char t)
	{
		super(n, p, t);
	}
	
	/**
	 * This returns the total depending upon the quantity
	 * @return the total depending on the quantity
	 */
	public double total(int qty)
	{
		if (Order.getAmount() < 100)
		{
			return qty * getPrice();
		}
		else if (Order.getAmount() < 500)
		{
			return (qty * getPrice()) * .95;
		}
		else if (Order.getAmount() < 1500)
		{
			return (qty * getPrice()) * .85;
		}
		else if (Order.getAmount() < 2500)
		{
			return (qty * getPrice()) * .75;
		}
		else
		{
			return -1;
		}
	}
}

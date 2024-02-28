
public abstract class Product{
	
	public static int invSize;//variables
	private String name;
	private double price;
	private char type;
	
	/**
	 * The constructor takes in a string a double and a char and assigns them to the name price and type
	 * @param n
	 * @param p
	 * @param t
	 */
	public Product(String n, double p, char t)
	{
		name = n;
        price = p;
        type = t;
	}
	
	/**
	 * returns the name
	 * @return name Returns the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * returns the price
	 * @return price Returns the price
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * returns the type
	 * @return type Returns the type
	 */
	public char getType()
	{
		return type;
	}
	
	/**
	 * returns the total
	 * @return total the qty * price
	 */
	public double total(int qty)
	{
		return qty * price;
	}
	
	/**
	 * The to string method
	 * @return String returns a nice string
	 */
	public String toString()
	{
		return "Name:" + name + ", price:" + price + ", type:" + type;
	}
}


public class Order {

	//In the UML
	private Product product;//variables
	private static int qw;
	private Date date;
	
	/**
	 * The constructor, takes in a product object an int and a date object and sets  variables equal to that
	 * 
	 * @param p The Product object
	 * @param q The quantity
	 * @param d The Date object
	 */
	public Order(Product p, int q, Date d)
	{
		product = p;
		qw = q;
		date = d;
		//total= (float) p.total(q);
	}
	
	/**
	 * Returns the date object
	 * @return date, the date
	 */
	public Date getDate()
	{
		return date;
	}
	
	/**
	 * Returns the product object
	 * @return product, the product
	 */
	public Product getProduct()
	{
		return product;
	}
	
	/**
	 * The toString method,
	 * @return String, this returns a string that looks nice with all fields of an order object
	 */
	public String toString()
	{
		return product.toString() + " Quantity: " + qw + " Date:" + date.toString() + " Total:$" + product.total(qw);
	}
	
	public static int getAmount()
	{
		return qw;
	}
}

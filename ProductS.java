
public class ProductS extends Product{
	
	/**
	 * This is the constructor it takes in a String double and char and assigns them to name price and type using the 
	 * superclass constructor
	 * 
	 * @param n The name
	 * @param p The price 
	 * @param t The type
	 */
	public ProductS(String n, double p, char t)
	{
		super(n, p, t);
	}
	
	/**
	 * returns the total depending on the month
	 * @return total returns the total, if in November December or January it is discounted.
	 */
	public double total(int qty)
	{
		Date currentDate = P3Driver_ZS949996.listOfOrders[P3Driver_ZS949996.searchTracker].getDate();
		
		//int currentMonth = Driver.listOfOrders[Driver.searchTracker].getMonth();
		
		
		if(currentDate.getMonth() == 11 || currentDate.getMonth() == 12 || currentDate.getMonth() ==1)
		{
			return (qty * getPrice()) * .4;
		}
		else if (currentDate.getMonth() == 2 || currentDate.getMonth() == 3 || currentDate.getMonth() == 4 || 
				 currentDate.getMonth() == 5 || currentDate.getMonth() == 6 || currentDate.getMonth() == 7 || 
				 currentDate.getMonth() == 8 || currentDate.getMonth() == 9 || currentDate.getMonth() == 10)
		{
			return qty * getPrice();
		}
		else return -1;
	}
	
	
}  
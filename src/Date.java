
public class Date {

	private int day;//variables
	private int month;
	private int year;
	
	/**
	 * This takes in three ints and sets variables equal to them
	 * @param m The month
	 * @param d The day
	 * @param y The year
	 */
	public Date(int m, int d, int y)
	{
		month = m;
		day = d;
		year = y;
	}
	
	/**
	 * Takes an int and sets the day to it
	 * 
	 * @param d The day
	 */
	public void setDay(int d)
	{
		day = d;//day
	}
	
	/**
	 * Takes an int and sets the month to it
	 * 
	 * @param d The month
	 */
	public void setMonth(int m)
	{
		month = m;//month
	}
	
	/**
	 * Takes an int and sets the year to it
	 * 
	 * @param d The year
	 */
	public void setYear(int y)
	{
		year = y;//year
	}
	
	/**
	 * Gets the day
	 * 
	 * @return Day, returns the day
	 */
	public int getDay()
	{
		return day;//day
	}
	
	/**
	 * Gets the month
	 * 
	 * @return Month, returns the day
	 */
	public int getMonth()
	{
		return month;//month
	}
	
	/**
	 * Gets the year
	 * 
	 * @return Year, returns the year
	 */
	public int getYear()
	{
		return year;//year
	}
	
	/**
	 * The toString method
	 * 
	 * returns a string that looks like a date in US format
	 */
	public String toString()
	{
		return month + "/" + day + "/" + year;//The String of a date
	}
	
}

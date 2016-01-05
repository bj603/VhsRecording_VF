package hu.sonrisa.vhs;

public class Show 
{
	private TimeStamp startTime;
	private TimeStamp endTime;
	private String name;
	
	public Show(String start, String end, String name)
	{
		this.startTime = TimeStamp.convertStringToTime(start);
		this.endTime = TimeStamp.convertStringToTime(end);
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public TimeStamp getStart()
	{
		return this.startTime;
	}
	
	public TimeStamp getEnd()
	{
		return this.endTime;
	}
	
	public int getStartForSorting()
	{
		return this.startTime.convertTimeToNumber();
	}
}

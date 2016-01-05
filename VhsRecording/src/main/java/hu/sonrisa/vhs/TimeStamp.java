package hu.sonrisa.vhs;

public class TimeStamp 
{
	private int hour;
	private int minute;
	
	public TimeStamp()
	{
		this.hour = 12;
		this.minute = 0;
	}
	
	public TimeStamp(int h, int min) throws InvalidDateException
	{
		if(h > 23 || h < 0)
		{
			throw new InvalidDateException();
		}
		else
		{
			this.hour = h;
		}
		
		if(min < 0 || min > 59)
		{
			throw new InvalidDateException();
		}
		else
		{
			this.minute = min;
		}
	}

	public int getHour() 
	{
		return this.hour;
	}

	public int getMinute() 
	{
		return this.minute;
	}
	
	public static TimeStamp convertStringToTime(String toRead)
	{
		try
		{
			return convertToTime(toRead);
		}
		catch(InvalidDateException e)
		{
			System.out.println("Invalid time format! Using default time (12:00) instead.");
			return new TimeStamp();
		}
	}
	
	private static TimeStamp convertToTime(String toRead) throws InvalidDateException
	{
		String hourString = toRead.substring(0, 2);
		String minuteString = toRead.substring(2,4);
		int hour = Integer.parseInt(hourString);
		int minute = Integer.parseInt(minuteString);
		return new TimeStamp(hour, minute);
	}
	
	public int convertTimeToNumber()
	{
		int result;
		if(10 <= this.hour)
		{
			if(10 <= this.minute)
			{
				result = Integer.valueOf(String.valueOf(this.hour) + String.valueOf(this.minute));
			}
			else
			{
				result = Integer.valueOf(String.valueOf(this.hour) + String.valueOf(0) + String.valueOf(this.minute));
			}
		}
		else
		{
			if(10 <= this.minute)
			{
				result = Integer.valueOf(String.valueOf(0) + String.valueOf(this.hour) + String.valueOf(this.minute));
			}
			else
			{
				result = Integer.valueOf(String.valueOf(0) + String.valueOf(this.hour) + String.valueOf(0) + String.valueOf(this.minute));
			}
		}
		return result;
	}
	@Override
	public String toString()
	{
		String hourString = String.valueOf(this.getHour());
		String minuteString = String.valueOf(this.getMinute());
		return hourString + ":" + minuteString;
		
	}
}

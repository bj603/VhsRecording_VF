package hu.sonrisa.vhs;

public class InvalidDateException extends Exception
{
	private static final long serialVersionUID = -6771432344133300549L;

	public InvalidDateException()
	{
		super();
	}
	
	public InvalidDateException(String message)
	{
		super(message);
	}
	
	public InvalidDateException(Throwable cause) 
	{
		super(cause);
	}

	public InvalidDateException(String message, Throwable cause) 
	{
		super(message, cause);
	}
}

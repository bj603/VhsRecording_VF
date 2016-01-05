package hu.sonrisa.vhs;

public class InvalidFileException extends Exception 
{
	private static final long serialVersionUID = -4105311640467685122L;

	public InvalidFileException()
	{
		super();
	}
	
	public InvalidFileException(String message)
	{
		super(message);
	}
	
	public InvalidFileException(Throwable cause) 
	{
		super(cause);
	}

	public InvalidFileException(String message, Throwable cause) 
	{
		super(message, cause);
	}
}

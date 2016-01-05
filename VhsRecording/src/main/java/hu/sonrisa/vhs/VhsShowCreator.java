package hu.sonrisa.vhs;

public class VhsShowCreator
{
	public Show[] readAllShows(String listOfShows) throws InvalidFileException
	{
		String[] inputArray = listOfShows.split("\n");
		Show[] outputArray = new Show[inputArray.length];
		for(int i=0;i!=inputArray.length;i++)
		{
			outputArray[i] = this.readShowDetails(inputArray[i]);
		}
		return outputArray;
	}
	
	private Show readShowDetails(String current) throws InvalidFileException
	{
		String[] rawComponents = current.split(" ");
		this.checkFileValidity(rawComponents);
		String[] components = this.correctSpacesInTitle(rawComponents);
		String startTime = components[0];
		String endTime = components[1];
		String title = components[2];
		return new Show(startTime,endTime,title);
	}
	
	private void checkFileValidity(String[] components) throws InvalidFileException
	{
		if(components.length < 3)
		{
			throw new InvalidFileException();
		}
	}
	
	private String[] correctSpacesInTitle(String[] raw)
	{
		if(raw.length != 3)
		{
			String current = raw[2]+" ";
			for(int i=3;i!=raw.length;i++)
			{
				current += raw[i]+" ";
			}
			String[] output = new String[3];
			output[0] = raw[0];
			output[1] = raw[1];
			output[2] = current.substring(0, current.length()-1);;
			return output;
		}
		else
		{
			return raw;
		}
	}
}

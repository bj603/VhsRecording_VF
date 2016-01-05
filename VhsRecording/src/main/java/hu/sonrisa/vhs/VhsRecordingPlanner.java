package hu.sonrisa.vhs;

import java.util.ArrayList;
import java.util.List;

public class VhsRecordingPlanner implements RecordingPlanner
{

	@Override
	public List<String> planRecording(String listOfShows)
	{
		try
		{
			return this.plan(listOfShows);
		}
		catch(Exception e)
		{
			System.out.println("Invalid file format! Returning empty list...");
			return new ArrayList<String>();
		}
	}
	
	private List<String> plan(String listOfShows) throws InvalidFileException
	{
		VhsShowCreator creator = new VhsShowCreator();
		Show[] allShows = creator.readAllShows(listOfShows);
		List<Show> schedule = this.planShows(allShows);
		List<String> titleList = this.getTitles(schedule);
		return titleList;
	}
	
	private List<String> getTitles(List<Show> schedule)
	{
		List<String> titles = new ArrayList<String>();
		for(int i=0;i!=schedule.size();i++)
		{
			titles.add(schedule.get(i).getName());
		}
		return titles;
	}
	
	private List<Show> planShows(Show[] allShows)
	{
		List<Show> schedule = new ArrayList<Show>();
		List<Show> showList = this.createListOfShows(allShows);
		schedule.add(showList.get(0));
		for(int i = 1; i != showList.size(); i++)
		{
			if(toRecord(showList.get(i-1),showList.get(i)))
			{
				schedule.add(showList.get(i));
			}
		}
		return schedule;
		
	}
	
	private boolean toRecord(Show currentlyRecorded, Show nextShow)
	{
		if(currentlyRecorded.getEnd().getHour() > nextShow.getStart().getHour())
		{
			return false;
		}
		else if(currentlyRecorded.getEnd().getHour() == nextShow.getStart().getHour())
		{
			if(currentlyRecorded.getEnd().getMinute() <= nextShow.getStart().getMinute())
			{
				return true;
			}
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private List<Show> createListOfShows(Show[] showArray)
	{
		ShowQuickSorter sorter = new ShowQuickSorter();
		sorter.sort(showArray);
		List<Show> listOfShows = new ArrayList<Show>();
		for(int i = 0;i!=showArray.length;i++)
		{
			listOfShows.add(showArray[i]);
		}
		return listOfShows;
	}

}

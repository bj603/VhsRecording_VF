package hu.sonrisa.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import hu.sonrisa.vhs.VhsRecordingPlanner;

public class VhsRecordingPlannerTest 
{

	@Test
	public void testRecordingPlanner() 
	{
		String listOfShows = "1535 1610 Pokémon\n1610 1705 Law & Order\n"
				+ "1615 1635 ER\n1615 1635 Ellen\n"
				+ "1615 1705 Family Matters\n1725 1810 The Fresh Prince of Bel-Air";
		VhsRecordingPlanner planner = new VhsRecordingPlanner();
		List<String> schedule = planner.planRecording(listOfShows);
		
		assertEquals("Pokémon",schedule.get(0));
		assertEquals("Law & Order",schedule.get(1));
		assertEquals("The Fresh Prince of Bel-Air",schedule.get(2));
	}
	
	@Test
	public void testRecordingPlannerUnsorted() 
	{
		String listOfShows = "1610 1705 Law & Order\n"
				+ "1615 1635 ER\n1615 1635 Ellen\n"
				+ "1615 1705 Family Matters\n1725 1810 The Fresh Prince of Bel-Air\n"
				+ "1535 1610 Pokémon";
		VhsRecordingPlanner planner = new VhsRecordingPlanner();
		List<String> schedule = planner.planRecording(listOfShows);
		
		assertEquals("Pokémon",schedule.get(0));
		assertEquals("Law & Order",schedule.get(1));
		assertEquals("The Fresh Prince of Bel-Air",schedule.get(2));
	}

}

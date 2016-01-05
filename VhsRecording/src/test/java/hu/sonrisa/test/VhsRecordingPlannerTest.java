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
        
        /**
         * Test case: Input contains a long and few short shows. The long 
         * one covers all the others.
         * 
         * Expected result: All the short shows will be recorded.
         * 
         */
	@Test
	public void testRecordingPlannerALongAndManyShort() 
	{
                // arrange
		String listOfShows = "1000 1800 Law & Order\n"
				+ "1100 1115 ER\n"
                                + "1200 1215 Ellen\n"
				+ "1300 1315 Family Matters\n"
                                + "1400 1415 The Fresh Prince of Bel-Air\n"
				+ "1500 1515 Pokémon";
		VhsRecordingPlanner planner = new VhsRecordingPlanner();
                
                // act
		List<String> schedule = planner.planRecording(listOfShows);
		
                // assert
                final String[] expectedResult = {"ER", "Ellen", "Family Matters", "The Fresh Prince of Bel-Air", "Pokémon"};
                assertEquals(expectedResult.length, schedule.size());                
                for(int i = 0; i<expectedResult.length; i++){
                    assertEquals(expectedResult[i], schedule.get(i));
                
                }
	}

}

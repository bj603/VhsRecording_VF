package hu.sonrisa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.sonrisa.vhs.InvalidFileException;
import hu.sonrisa.vhs.Show;
import hu.sonrisa.vhs.VhsShowCreator;

public class VhsShowCreatorTest 
{

	@Test
	public void testReadAllFiles() 
	{
		try 
		{
			String listOfShows = "1535 1610 Pokémon\n1610 1705 Law & Order\n1615 1635 ER";
			VhsShowCreator creator = new VhsShowCreator();
			Show[] shows;
			shows = creator.readAllShows(listOfShows);
			assertEquals("Pokémon",shows[0].getName());
			assertEquals("Law & Order",shows[1].getName());
			assertEquals("ER",shows[2].getName());
		} 
		catch (InvalidFileException e) 
		{
			fail("An exception should not be thrown with normal input.");
		}
	}
	
	@Test
	public void testReadFileDetails() 
	{
		try 
		{
			String listOfShows = "1535 1610 Pokémon";
			VhsShowCreator creator = new VhsShowCreator();
			Show[] shows;
			shows = creator.readAllShows(listOfShows);
			assertEquals("Pokémon",shows[0].getName());
			assertEquals("15:35",shows[0].getStart().toString());
			assertEquals("16:10",shows[0].getEnd().toString());
		} 
		catch (InvalidFileException e) 
		{
			fail("An exception should not be thrown with normal input.");
		}
		
	}
	
	@Test
	public void testReadFileInvalidData()
	{
		try 
		{
			String listOfShows = "1135 1230";
			VhsShowCreator creator = new VhsShowCreator();
			@SuppressWarnings("unused")
			Show[] shows = creator.readAllShows(listOfShows);
			fail("An exception should have been thrown.");
		} 
		catch (InvalidFileException e) 
		{
			//Test Succeeds if Exception is caught.
		}
	}
	
	@Test
	public void testCorrectSpaces()
	{
		try 
		{
			String listOfShows = "1135 1230 The Good, the Bad and the Ugly";
			VhsShowCreator creator = new VhsShowCreator();
			Show[] shows = creator.readAllShows(listOfShows);
			assertEquals("The Good, the Bad and the Ugly",shows[0].getName());
		} 
		catch (InvalidFileException e) 
		{
			fail("An exception should not be thrown with normal input.");
		}
	}
}

package hu.sonrisa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.sonrisa.vhs.Show;

public class ShowTest 
{

	@Test
	public void testConstructor() 
	{
		Show testShow = new Show("1510","1610","Downton Abbey");
		assertEquals("Downton Abbey",testShow.getName());
		assertEquals(15,testShow.getStart().getHour());
		assertEquals(10,testShow.getStart().getMinute());
		assertEquals(16,testShow.getEnd().getHour());
		assertEquals(10,testShow.getEnd().getMinute());
	}
	
	@Test
	public void testGetStartForSorting() 
	{
		Show testShow = new Show("1510","1610","Downton Abbey");
		assertEquals(1510,testShow.getStartForSorting());
	}

}

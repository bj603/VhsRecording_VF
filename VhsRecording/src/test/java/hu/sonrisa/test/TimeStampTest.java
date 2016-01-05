package hu.sonrisa.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hu.sonrisa.vhs.InvalidDateException;
import hu.sonrisa.vhs.TimeStamp;

public class TimeStampTest 
{

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testDefaultConstructor() 
	{
		TimeStamp time = new TimeStamp();
		assertEquals(12,time.getHour());
		assertEquals(0,time.getMinute());
	}
	
	@Test
	public void testConstructorNormalValue()
	{
		TimeStamp time;
		try 
		{
			time = new TimeStamp(23,35);
			assertEquals(23, time.getHour());
			assertEquals(35, time.getMinute());
		} 
		catch (InvalidDateException e) 
		{
			fail("Initalization with normal data should not throw exception");
		}
	}
	
	@Test
	public void testConstructorInvalidValue()
	{
		try 
		{
			@SuppressWarnings("unused")
			TimeStamp time = new TimeStamp(40,50);
			fail("Should have thrown an exception"); 
		} 
		catch (InvalidDateException e) 
		{
			//Test Succeeds if Exception is caught.
		}
	}
	
	@Test
	public void testConvertStringToTime()
	{
		TimeStamp time = TimeStamp.convertStringToTime("1350");
		assertEquals("13:50",time.toString());
	}

}

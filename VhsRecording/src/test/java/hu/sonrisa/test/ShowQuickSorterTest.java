package hu.sonrisa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.sonrisa.vhs.Show;
import hu.sonrisa.vhs.ShowQuickSorter;

public class ShowQuickSorterTest {

	@Test
	public void testSort() 
	{
		Show[] arrayToTest = new Show[5];
		arrayToTest[0] = new Show("1530","1600","Family Guy"); 
		arrayToTest[1] = new Show("1430","1500","Friends");
		arrayToTest[2] = new Show("1610","1710","Game of Thrones");
		arrayToTest[3] = new Show("1100","1200","How I Met Your Mother");
		arrayToTest[4] = new Show("1750","1830","NCIS"); 
		
		ShowQuickSorter sorter = new ShowQuickSorter();
		sorter.sort(arrayToTest);
		assertEquals("How I Met Your Mother",arrayToTest[0].getName());
		assertEquals("Friends",arrayToTest[1].getName());
		assertEquals("Family Guy",arrayToTest[2].getName());
		assertEquals("Game of Thrones",arrayToTest[3].getName());
		assertEquals("NCIS",arrayToTest[4].getName());
	}

}

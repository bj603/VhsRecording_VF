package hu.sonrisa.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TimeStampTest.class, ShowTest.class, VhsShowCreatorTest.class,
				VhsRecordingPlannerTest.class, ShowQuickSorterTest.class})
public class AllTests 
{

}

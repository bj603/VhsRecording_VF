package hu.sonrisa.vhs;

import java.util.List;

/**
 * Interface of the VHS recording planner.
 *
 * @author sonrisa
 */
public interface RecordingPlanner {
    
    /**
     * 
     * All nineties kids will remember the problem of having 
     * to program their vhs recorder to tape all their favorite shows. 
     * Especially when 2 shows are aired at the same time, which show do we record?
     * 
     * Today we are going to program the recorder, 
     * so that we have a maximum amount of tv shows on one tape.
     * 
     * You recieve a timetable with when the shows start, when it ends and their titles.      
     * All times are in Military time.
     * Times and titles are separeted with a space, every show is in a new line.
     * 
     * Example input:
     * 
     * 1535 1610 Pokémon
     * 1610 1705 Law & Order
     * 1615 1635 ER
     * 1615 1635 Ellen
     * 1615 1705 Family Matters
     * 1725 1810 The Fresh Prince of Bel-Air
     * 
     * You return the maximum number of shows you can record. 
     * We can switch between channels instantaneously, 
     * so if a shows start on the same time a other one stops, you can record them.
     * 
     * Example output:
     * 
     * Pokémon
     * Law & Order
     * The Fresh Prince of Bel-Air
     * 
     * @param listOfShows
     * 
     * @return 
     */
    List<String> planRecording(String listOfShows);
    
}

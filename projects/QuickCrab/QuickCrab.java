
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList; 

public class QuickCrab extends CrabCritter
{

  public QuickCrab()
  {
    setColor(Color.RED);
  }

  /**
 * @return list of empty locations
 * two locations to the right and two locations to the left
 gives possible places that the crab can move that are two spaces away
 */
 public ArrayList<Location> getMoveLocations()
 {
 ArrayList<Location> locs = new ArrayList<Location>();
 Grid g = getGrid();

 twoMove(locs,getDirection() + Location.LEFT);
 twoMove(locs,getDirection() + Location.RIGHT);

 if (locs.size() == 0)
 return super.getMoveLocations(); 

 return locs;
 }


 /**
 * Adds a valid and empty two away location in direction dir to the
 * ArrayList locs.
 * To be a valid two step location, the the path to get there (the spot inbetween) in direction dir must also be valid and empty.
 */
 private void twoMove(ArrayList<Location> locs,int dir)
 {
 Grid g = getGrid();
 Location loc = getLocation();

 Location temp = loc.getAdjacentLocation(dir);

 if(g.isValid(temp) && g.get(temp) == null) //if first spot is a spot in the grid and empty
 {
 Location loc2 = temp.getAdjacentLocation(dir); //gets space next to the first space (adjacent)
 if(g.isValid(loc2) && g.get(loc2)== null) //checks if second spot is a spot in the grid and empty
 locs.add(loc2);
 }
 } 
}
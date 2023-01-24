
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/**
a class with a crab that makes its neighbors move one space away from the crab, if the neighbor cant move then it is removed/eaten
when the KingCrab finishes processing the other actors, it moves and acts like a normal CrabCritter
*/
public class KingCrab extends CrabCritter
{

public KingCrab()
{
  setColor(Color.BLUE);
}


/**
 * Computes the distance between two spaces.
 */
 public int distanceFrom(Location loc1, Location loc2)
 {
 int x1 = loc1.getRow();
 int y1 = loc1.getCol();
 int x2 = loc2.getRow();
 int y2 = loc2.getCol();
 double dist = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)) + .5; // distance between two points-- distance formula
 return (int)Math.floor(dist);
 } 

  /** 
  moves crab neighbor one space away from the KingCrab if it is directly adjacent to it and returns true
 if there is no location for the neighbor to move to the method returns false and it doesnt move
 
 */
 private boolean moveAway(Actor a)
 {
 ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(a.getLocation()); //finds empty locations in grid

 for(Location loc:locs)
 {
 if(distanceFrom(getLocation(), loc) > 1)
 {
 a.moveTo(loc);
 return true;
 }
 }

 return false;
 } 

 /**
method that processes actors
if they can move one space from the crab then they do
if they cant, they are removed from the grid aka eaten
@param Actors the actors that get processed
 */
 public void processActors(ArrayList<Actor> actors)
 {
 for (Actor a : actors) //loops through whole array list of actors in the grid
 {
 if (!moveAway(a)) 
 {
 a.removeSelfFromGrid();
 }
 }
 } 
}
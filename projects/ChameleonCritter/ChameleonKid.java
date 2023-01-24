import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
//import info.gridworld.grid.Flower;

import java.util.ArrayList;

/**
a chameleon that takes on the color of neighboring actors in front of or behind it as it moves
if there is no actor directly in front of or behind it then it darkens like a ChameleonCritter
*/
public class ChameleonKid extends ChameleonCritter
{
  
public ArrayList<Actor>getActors()
{
  ArrayList<Actor> actors = new ArrayList<Actor>();
 int[] dirs = { Location.AHEAD, Location.HALF_CIRCLE };//locations in front of or behind it
 for (Location loc : getLocationsInDirections(dirs)) //gets all front and back locations in array
 {
 Actor a = getGrid().get(loc);
 if (a != null)
 actors.add(a);
 }
 return actors; 
}
/**
returns the loctions that are neighbors to the chameleons current location, gives the direction
@param directions the directions the neighbors are in
*/
public ArrayList<Location> getLocationsInDirections(int[] directions)
 {
 ArrayList<Location> locs = new ArrayList<Location>();
 Grid gr = getGrid();
 Location loc = getLocation();

 for (int d : directions)
 {
 Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
 if (gr.isValid(neighborLoc))
 locs.add(neighborLoc); //if there is a adjacent neighbor its location is added to an array
 }
 return locs;
 } 



}
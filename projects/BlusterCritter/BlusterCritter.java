import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color; 


/**
class with BlusterCritters which scan at all neighbors within 2 spaces of them 
if the number of total critters in those locations is more than or equal to the courage then it gets darker if they are less than the courage then it gets lighter
*/
public class BlusterCritter extends Critter
{

private int courage;
private static final double DARKENING_FACTOR = 0.05; //percent the critter darkens or lightens each time

public BlusterCritter(int c)
  {
    super();
    courage = c;
  }

 /**
 * Gets the actors in the grid for processing. return the actors that
 * occupy neighboring grid locations within two steps of the critter
 * @return a list of actors that are neighbors of this critter
 */
 public ArrayList<Actor> getActors()
 {
 ArrayList<Actor> actors = new ArrayList<Actor>();

 Location loc = getLocation();
 for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ ) //for the two rows to the right andd to the left
 for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++) //for the rows two above and below
 {
 Location tempLoc = new Location(r,c);
 if(getGrid().isValid(tempLoc))
 {
 Actor a = getGrid().get(tempLoc);
 if(a != null && a != this)
 actors.add(a);
 }
 }
 return actors;
 } 


  /**
 * Processes the actors. counts actors within
 * 2 spaces of critter. If there are fewer than courage
 * critters in these locations, BlusterCritter lightens, otherwise
 * it darkens.
 * @param actors the actors to be processed
 */
 public void processActors(ArrayList<Actor> actors)
 {
 int count = 0;
 for(Actor a: actors)
 if(a instanceof Critter)
 count++;
 if(count < courage)
 lighten();
 else
 darken();
 } 

 /**
 * Darkens color by subtracting the darkening factor from red, green, and blue components.
 */
 private void darken()
 {
 Color c = getColor();
 int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
 int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
 int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
 setColor(new Color(red, green, blue));
}

/**
 * lightens color by subtracting adding the darkening factor from red, green, and blue components.
 */
 private void lighten()
 {
 Color c = getColor();
 int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
 int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
 int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
 setColor(new Color(red, green, blue));
}
}
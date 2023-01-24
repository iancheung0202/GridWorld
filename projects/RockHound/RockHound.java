
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location; 
import java.util.ArrayList;

/**
a class that processes actors and "eats" all the rocks and removes them from the grid
*/
public class RockHound extends Critter
{


/**
modified method of Critter that removes all rocks from the grid when processing
@param actors the actors that get processed
*/
public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof Rock)
                a.removeSelfFromGrid();
        }
    }


}
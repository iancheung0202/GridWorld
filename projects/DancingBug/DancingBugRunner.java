
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
class that runs the DangingeBug class
creates DancingBug objects, sets their color, and places them at a location in the world
the array is the list of the dancing steps of the bug
*/
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        int[] turn = {2,5,1,3};
        DancingBug alice = new DancingBug(turn);
        alice.setColor(Color.ORANGE);
    
        world.add(new Location(7, 8), alice);
    
        world.show();
    }
}
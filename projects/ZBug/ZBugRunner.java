import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
class that runs the ZBug class
creates ZBug objects, sets their color, and places them at a location in the world
parameter is the length of each z segment (every segment is equal)
*/
public class ZBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        ZBug alice = new ZBug(6);
        alice.setColor(Color.BLUE);
        world.add(new Location(1, 1), alice);
        world.show();
    }
}
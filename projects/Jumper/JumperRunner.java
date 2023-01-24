import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

/**
class that runs the Jumper bug class
bug can skip a space and land on rocks flowers or an empty space
it can also turn if it runs into a wall
*/
public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Jumper());
        world.add(new Rock());
        world.add(new Flower();)
        world.show();
    }
}

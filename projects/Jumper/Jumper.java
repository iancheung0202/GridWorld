import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;

import java.awt.Color;

/**
 an actor that jumps every other space and can jump over rocks and flowers
 */
public class Jumper extends Actor
{
    /**
     * Constructs a red jumper.
     */
    public Jumper()
    {
        setColor(Color.RED);
    }

    /**
      contructs a Jumper of a certain color
      @param JumpColor
    */

    public Jumper(Color JumpColor)
    {
      setColor(JumperColor)
    }

    
    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canJump())
            jump();
        else
            turn();
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    /**
     * Moves the bug forward two spaces, putting a flower into the location it previously
     * occupied.
     if next location is occupied it removes itself from the grid
     */
    public void Jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(twoSpaces))
            moveTo(twoSpaces);
        else
            removeSelfFromGrid();
    }

    /**
     * Tests whether this bug can "jump" two spaces ahead
     * contains a flower.
     * @return true if this the space is empty, has a flower, or has a rock in it (just removes the flower or rock).
     */
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        if (!((neighbor == null) || (neighbor instanceof Flower) || (neighbor instanceof Rock)));
          return false;

        //gets space next to the first space aka the second space
        Location twoSpaces = next.getAdjacentLocation(getDirection());
        if(!gr.isValid(twoSpaces)) // if the 2nd space away isnt empty, a flower or a rock
          return false;

        neighbor = gr.get(twoSpaces);
        return ((neighbor==null) || (neigher instanceofFlower));

    }
}

import info.gridworld.actor.Bug;


public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;

    /**
     * Constructs a spiral bug that traces a spiral starting with a given side length
     * @param length the side length of the spiral
     */
    public SpiralBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
            sideLength++; //each turn the side length increases by 1 to make a spiral path
        }
    }
}

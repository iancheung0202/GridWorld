import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int [] turn;
    private int step; //step the bug is on

    /**
     * Constructs a dancing bug that traces a square of a given side length
     * @param turning[] and array that lays out the steps of the bugs dancing pattern
     */
    public DancingBug(int [] turning)
    {
        turn = turning;
        step = 0;
    }

    /**
     * Moves to the next location of the square.
     */
    public void turn(int times)
    {
        for(int i = 1; i<= times; i++)
        {
          turn();
        }
    }

    public void act()
    {
      if(step == turn.length)
      {
        step = 0; //gets dancing bug to continue repeating the same turning pattern
      }
        
        turn(turn[step]);
        step++;
        super.act(); //once the bug has turned the set amount of times it acts like a normal bug
      
    }
}

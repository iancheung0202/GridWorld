import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug
{
    private int steps; //length of each segment of z
    private int sideLength; //total length of z
    //private int segment; //bugs position on the Z (one of three segments of letter Z)

    /**
     * Constructs a bug that traces a z of a given segment length
     * @param length the side length of each segment of the Z
     */
    public ZBug(int length)
    {
      
      setDirection(Location.EAST); //bug starts facing right
        steps = 0;   
        sideLength = length;
    }

    public void act()
    {
        if (steps < sideLength && canMove()) 
        {
            move();
            steps++;
        }

         else if(steps==sideLength)//top part of Z aka first segment
        {
          setDirection(Location.SOUTHWEST); //turns bug into the path for diagonal
          if(canMove())
            {
              move();
            }
          steps++;
        }

       else if(steps<sideLength*2 && canMove())
        {
          move();
          steps++;
        }

       else if(steps==sideLength*2) //diagonal segment aka second segment
        {
          setDirection(Location.EAST); //turns bug into path for bottom part/last segment
          if(canMove())
            {
              move();
            }
          steps++; 
        }
        
        else if(steps<sideLength*3 && canMove()) //moves bug through the last segment of z
        {
          move();
          steps++;
        }

        }
  
  
}


public void act()
{
  if(segment<=3 && steps < sideLength)
  {
    if(canMove())
      {
        move();
        steps++;
      }
  else if(segment==1)
  {
    setDirection(Location.EAST);
    steps=0;
    segment++;
  }
  else if(segment==2)
  {
    setDirection(Location.NORTHEAST);
    steps=0;
    segment++;
  }
  else if(segment>3)
  {
    turn();
    segment++;
  }
  }
}
package RaceAI.AI;

public class Node
{
    public boolean opened,
                   closed;
    public int x, y;
    /* 
        distanceFromStart;
        heuristicDistanceFromGoal;
    */
    double f, g, h;
    public char value;
    public Node parent;

    public Node()
    {
        this(0, 0);
    }

    public Node(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.f = this.g = 0;
        // -1 indicate that value weren't set yet
        this.h = -1;
        this.value = '?';
        this.opened = this.closed = false;
        this.parent = null;
    }

    public void setCoordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setValue(char value)
    {
        this.value = value;
    }
}
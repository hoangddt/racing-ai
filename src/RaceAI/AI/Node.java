package RaceAI.AI;

public class Node
{
    public boolean opened,
                    closed;
    public int x, y, f, g, h;
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
        this.f = this.g = this.h = 0;
        value = '?';
    }

    public setCoordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public setValue(char value)
    {
        this.value = value;
    }
}
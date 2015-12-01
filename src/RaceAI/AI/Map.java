package RaceAI.AI;

import RaceAI.AI.Node;

public class Map
{
    private Node[][] nodes;
    public int width, height;
    public Node startNode;
    public Node endNode;

    public Map(int x, int y)
    {
        this.width = x;
        this.height = y;
        this.nodes = new Node[this.width][this.height];
        this.init();
    }

    public void init()
    {
        // update x, y and value for each node
        for (int i = 0; i < this.width; i++)
        {
            for (int j = 0; j < this.height; j++)
            {
                this.nodes[i][j].setCoordinate(j, i);
            }
        }
        this.startNode = this.getNodeAt(1, 1);
        this.endNode = this.getNodeAt(this.width - 1, this.height - 1);
    }

    public void setValueAt(int x, int y, char val)
    {
        this.nodes[y][x].setValue(val);
    }

    public Node getNodeAt(int x, int y)
    {
        return this.nodes[y][x];
    }

    public boolean isStartNode(Node node)
    {
        if (this.startNode.x == node.x && this.startNode.y = node.y)
            return true;
        else return false;
    }

    public boolean isEndNode(Node node)
    {
        if (this.endNode.x == node.x && this.endNode.y = node.y)
            return true;
        else return false;
    }

    public boolean isWalkableAt(int x, int y)
    {
        switch (this.nodes[y][x].value)
        {
            case '1':
            case '?':
                return false;
            default:
                return true;
        }
    }
    public Stack<Node> getNeighbors(Node node)
    {
        Stack<node> neightbors = new Stack<Node>();
        int x = node.x,
            y = node.y;

        // check up
        if (this.isWalkableAt(x, y - 1))
        {
            neightbors.push(this.nodes[y-1][x]);
        }

        // check right
        if (this.isWalkableAt(x + 1, y))
        {
            neightbors.push(this.nodes[y][x + 1]);
        }

        // check down
        if (this.isWalkableAt(x, y + 1))
        {
            neightbors.push(this.nodes[y + 1][x]);
        }

        // check left
        if (this.isWalkableAt(x - 1, y))
        {
            neightbors.push(this.nodes[y-1][x]);
        }
        return neightbors;
    }

    public Point[] backTrack(Node node)
    {
        // ToDO: implement this to find parent
        // and store in an array of pair x, y
        return;
    }
}
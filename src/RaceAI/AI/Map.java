package RaceAI.AI;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.Point;
import RaceAI.AI.Node;

public class Map
{
    private Node[][] nodes;
    public int width, height;
    public Node startNode;
    public Node endNode;

    // ToDo: Apply singleton design pattern
    
    public Map(int x, int y)
    {
        // width and height is in map perpective
        // not in array perpective
        this.width = x;
        this.height = y;
        this.nodes = new Node[this.height][this.width];
        this.init();
    }

    public void init()
    {
        // update x, y and value for each node
        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.width; j++)
            {
                this.nodes[i][j] = new Node(j, i);
            }
        }
        this.startNode = this.getNodeAt(1, 1);
        this.endNode = this.getNodeAt(this.width - 1, this.height - 1);
    }

    public void updateMapByArray(char [][]arr)
    {
        // This method is just for test
        for (int i = 0; i < this.width; i++)
        {
            for (int j = 0; j < this.height; j++)
            {
                this.nodes[i][j].setValue(arr[j][i]);
            }
        }
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
        if ( (this.startNode.x == node.x) && (this.startNode.y == node.y) )
            return true;
        else return false;
    }

    public boolean isEndNode(Node node)
    {
        if ( (this.endNode.x == node.x) && (this.endNode.y == node.y) )
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

    public ArrayList<Node> getNeighbors(Node node)
    {
        ArrayList<Node> neightbors = new ArrayList<Node>();
        int x = node.x,
            y = node.y;

        // check up
        if (this.isWalkableAt(x, y - 1))
        {
            neightbors.add(this.nodes[y-1][x]);
        }

        // check right
        if (this.isWalkableAt(x + 1, y))
        {
            neightbors.add(this.nodes[y][x + 1]);
        }

        // check down
        if (this.isWalkableAt(x, y + 1))
        {
            neightbors.add(this.nodes[y + 1][x]);
        }

        // check left
        if (this.isWalkableAt(x - 1, y))
        {
            neightbors.add(this.nodes[y][x - 1]);
        }

        return neightbors;
    }

    public ArrayList<Point> backTrace(Node node)
    {
        ArrayList<Point> path = new ArrayList<Point>();
        path.add(new Point(node.x, node.y));

        while (node.parent != null)
        {
            node = node.parent;
            path.add(new Point(node.x, node.y));
        }

        // Reverse and Array: http://ideone.com/ELtOEe
        Collections.reverse(path);
        return path;
    }
}
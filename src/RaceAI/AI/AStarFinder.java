package RaceAI.AI;

import java.util.ArrayList;  /* use to get neighbors */
import java.awt.Point;      /* use to store array of path */
import RaceAI.AI.Node;

class AstarFinder
{
    private int _weight;

    public AstarFinder()
    {
        this._weight = 1;
    }

    public ArrayList<Point> findPath(int startX, startY, endX, endY, Map map)
    {
        // ToDo: write Heap class
        Heap openList = new Heap();
        Node startNode = map.getNodeAt(startX, startY),
             endNode = map.getNodeAt(endX, endY);
        double SQRT2 = 1.4142135623730951;

        // set the `g` and `f` value of the start node to be 0
        startNode.g = 0;
        startNode.f = 0;

        // push the start node into the open list
        openList.push(startNode);
        startNode.opened = true;

        // while the open list is not empty
        while (!openList.empty())
        {
            // ToDo: pop the position of node which has the minimum `f` value.
            Node node = openList.pop();
            node.closed = true;

            // if reached the end position, construct the path and return it
            // ToDO: consider this should check x, y or check reference!
            if (node == endNode)
            {
                return map.backTrace(endNode);
            }

            // get neigbours of the current node
            ArrayList<Node> neighbors = map.getNeighbors(node);
            for (i = 0, l = neighbors.size(); i < l; ++i)
            {
                neighbor = neighbors.get(i);

                if (neighbor.closed)
                {
                    continue;
                }

                int x = neighbor.x;
                int y = neighbor.y;

                // get the distance between current node and the neighbor
                // and calculate the next g score
                int ng = node.g + ((x - node.x == 0 || y - node.y == 0) ? 1 : SQRT2);

                // check if the neighbor has not been inspected yet, or
                // can be reached with smaller cost from the current node
                if (!neighbor.opened || ng < neighbor.g)
                {
                    neighbor.g = ng;
                    neighbor.h = neighbor.h || this._weight * this.manhattan(Math.abs(x - endX), Math.abs(y - endY));
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = node;

                    if (!neighbor.opened)
                    {
                        openList.push(neighbor);
                        neighbor.opened = true;
                    } 
                    else
                    {
                        // the neighbor can be reached with smaller cost.
                        // Since its f value has been updated, we have to
                        // update its position in the open list
                        openList.updateItem(neighbor);
                    }
                }
            } // end for each neighbor
        } // end while not open list empty
        
        // fail to find the path
        return null;
    
    } // end find Path

    private int manhattan(int dx, int dy)
    {
        return dx + dy;
    }
}
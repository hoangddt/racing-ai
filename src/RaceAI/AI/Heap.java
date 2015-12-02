package RaceAI.AI;

import java.util.ArrayList;
import RaceAI.AI.Node;

class Heap
{
    private ArrayList<Node> _nodes;
    
    public Heap()
    {
        _nodes = new ArrayList<Node>();
    }

    public ArrayList<Node> push(Node item)
    {
        return this._heappush(this._nodes, item);
    }

    // pop the Node have smallest f property
    public Node pop()
    {
        return this._heappop(this._nodes, item);
    }

    public Node updateItem(Node node)
    {

    }

    public ArrayList<Node> _heappush(ArrayList<Node> array, Node item)
    {
        array.add(item);
        return _siftdown(array, 0, array.size() - 1);
    }

    public ArrayList<Node> _heappop(ArrayList<Node> array, Node item)
    {
        Node lastelt, returnitem;
        lastelt = this._popLastNode(array);
        if (array.size() != 0)
        {
            returnitem = array.get(0);
            // replace item at posiyion 0 by lastelf
            array.set(0, lastelt);
            this._siftup(array, 0);
        }
        else
        {
            returnitem = lastelt;
        }
        return returnitem;
    }

    private int _defaultCompare(Node nodeA, Node nodeB)
    {
        return nodeA.f - nodeB.f;
    }

    private Node _popLastNode(ArrayList<Node> array)
    {
        // return last Node and also remove that node
        // size decrease by 1
        // http://ideone.com/V9RIdR
        int lastPos = array.size() - 1;
        // ToDo: Handle if array is empty, lastPos < 0
        Node lastItem = array.get(pos);
        array.remove(pos);
        return lastItem;
    }

    private ArrayList<Node> _siftdown(ArrayList<Node> array, int startpos, int pos)
    {
        Node newItem, 
             parent;
        int parentpos;
        newItem = array.get(pos);
        while (pos > startpos)
        {
            parentpos = (pos -1) >> 1;
            parent = array.get(parentpos);
            if (this._defaultCompare(newItem, parent) < 0)
            {
                array.set(pos, parent);
                pos = parentpos;
                continue;
            }
            break;
        }
        array.set(pos, newItem);
        return array.get(pos);
    }

    private ArrayList<Node> _siftup(ArrayList<Node> array, int pos)
    {
        int childPos,
            endPos,
            rightPos,
            startPos;
        endPos = array.size();
        startPos = pos;
        Node newItem = array.get(pos);

        childPos = 2 + pos + 1;
        while (childPos < endPos)
        {
            rightPos = childPos + 1;
            if (rightPos < endPos && !(this._defaultCompare(array.get(childPos), array.get(rightPos))))
            {
                childPos = rightPos;
            }
            array.set(pos, array.get(childPos));
            pos = childPos;
            childPos = 2 * pos + 1;
        }
        array.set(pos, newItem);
        return this._siftdown(array, startpos, pos);
    }
}
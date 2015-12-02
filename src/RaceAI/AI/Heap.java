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

    public Node push(Node item)
    {
        return this._heappush(this._nodes, item);
    }

    // pop the Node have smallest f property
    public Node pop()
    {
        return this._heappop(this._nodes);
    }

    public boolean empty()
    {
        return this._nodes.size() == 0;
    }

    public Node updateItem(Node item)
    {
        return this._updateItem(this._nodes, item);
    }

    public Node _updateItem(ArrayList<Node> array, Node item)
    {
        int pos;
        // first index found
        pos = array.indexOf(item);
        if (pos == -1)
        {
            return null;
        }
        _siftdown(array, 0, pos);
        return _siftup(array, pos);
    }

    public Node _heappush(ArrayList<Node> array, Node item)
    {
        array.add(item);
        return _siftdown(array, 0, array.size() - 1);
    }

    public Node _heappop(ArrayList<Node> array)
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

    private double _defaultCompare(Node nodeA, Node nodeB)
    {
        // ToDo: consider may be cast to int
        return nodeA.f - nodeB.f;
    }

    private Node _popLastNode(ArrayList<Node> array)
    {
        // return last Node and also remove that node
        // size decrease by 1
        // http://ideone.com/V9RIdR
        int lastPos = array.size() - 1;
        // ToDo: Handle if array is empty, lastPos < 0
        Node lastItem = array.get(lastPos);
        array.remove(lastPos);
        return lastItem;
    }

    private Node _siftdown(ArrayList<Node> array, int startpos, int pos)
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

    private Node _siftup(ArrayList<Node> array, int pos)
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
            // ToDo: compare double to int, be aware wrong condition
            boolean secondCondition = this._defaultCompare(array.get(childPos), array.get(rightPos)) == 0;
            if ((rightPos < endPos) && secondCondition)
            {
                childPos = rightPos;
            }
            array.set(pos, array.get(childPos));
            pos = childPos;
            childPos = 2 * pos + 1;
        }
        array.set(pos, newItem);
        return this._siftdown(array, startPos, pos);
    }
}
package RaceAI.AI;

import RaceAI.AI.Node;
import RaceAI.AI.Heap;
import RaceAI.AI.Map;
import RaceAI.AI.AStarFinder;

// this class just for test AStar Algorithm
public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Map map = new Map(3, 4);
        AStarFinder aStar = new AStarFinder();
        System.out.println("Hello from AI Utils");
    }
}

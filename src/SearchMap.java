import java.util.ArrayDeque;
import java.util.ArrayList;


public class SearchMap
{
	/** Main entry point into the program.
	 * 
	 * @param args: Contains the commandline parameters.
	 * 1st param: String, input file name
	 * 2nd param: String, output file name
	 */
	public static void main(String[] args)
	{
		FlightMap map = new FlightMap(args[0]);
		
		Integer numFlightPathsLeft = map.numPaths();
		
		// track the most recently visited node.
		ArrayList<Node> cities = map.getFlightMap();
		ArrayDeque<Node> stack = new ArrayDeque<Node>();
		
		Node currNode = map.findStartNode();
		while(numFlightPathsLeft != 0)
		{
		}
		
		
		for(Node n: cities)
		{
			// start node so already have paths to adj cities
			if(n.isStartNode())
			{
				numFlightPathsLeft -= n.getAdjacentNodes().size();
			}
			for(Node adj: n.getAdjacentNodes().keySet())
			{
				stack.push(adj);
			}
		}
		
	}
	
	/**
	 * 
	 * @param outputFile
	 */
	public void writeSolution(String outputFile)
	{
		
	}
	
};
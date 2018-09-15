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
				
		// For DFS
		ArrayDeque<Node> stack = new ArrayDeque<Node>();
		Node currNode = null;
		stack.push(map.findStartNode());
		while(!stack.isEmpty())
		{
			// visit new node
			currNode = stack.pop();
			currNode.visited();
			
			// special case: start node is not connected to any other city
			if(currNode.getAdjacentNodes().isEmpty() && currNode.isStartNode())
			{
				break;
			}
			// add adjacent nodes onto the stack
			for(Node adj: currNode.getAdjacentNodes().keySet())
			{
				if(!adj.hasBeenVisited())
				{
					// add to the stack
					stack.push(adj);
					// set the parent node
					adj.setParentNode(currNode);
				}
			}
		}
		writeSolution(args[1], map);
	}
	
	/**
	 * 
	 * @param outputFile
	 */
	public static void writeSolution(String outputFile, FlightMap map)
	{
		Node parent = null;
		StringBuilder build = new StringBuilder();

		for(Node n: map.getFlightMap())
		{
			if(n.getParentNode() != null)
			{
				parent = n;
				while(parent != null)
				{
					build.append(parent.getName());
					build.append(",");
					
					parent = parent.getParentNode();
					
					
					
				}
				System.out.println(build.reverse());
				build.setLength(0);
			}
		}
	}
	
};
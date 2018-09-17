import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.*;

public class SearchMap
{	
	private final static String OUTPUT_FILE_HEADER = "Destination Flight Route from %s Total Cost";
	
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
				// hasnt been visited and not already on the stack
				if(!adj.hasBeenVisited() && !stack.contains(adj))
				{
					// add to the stack
					stack.push(adj);
					// set the parent node
					adj.setParentNode(currNode);
					// set the cost of the path.
					// cost is parents + edge cost between adj and parent
					adj.setCost(currNode.getCost() + currNode.getAdjacentNodes().get(adj));
					
				}
			}
		}
		// write solution to the file passed in 
		writeSolution(args[1], map);
	}
	/** Go through the graph creating the path from the start node to each destination node
	 * 
	 * @param map: FlightMap storing the graph
	 * @return ArrayList of Strings storing the path solutions
	 */
	private static ArrayList<String> reconstructSolution(FlightMap map)
	{
		Node parent = null;
		// Stringbuilders to build the solution string
		StringBuilder build = new StringBuilder();
		StringBuilder solution = new StringBuilder();
		
		// store the paths found
		ArrayList<String> paths = new ArrayList<String>();
		// reconstruct the answer
		for(Node n: map.getFlightMap())
		{
			// build path from the end node
			if(n.getParentNode() != null)
			{
				parent = n;
				
				// move up the tree
				while(parent != null)
				{
					// add parent to path 
					build.append(parent.getName());	
					parent = parent.getParentNode();
				
					if(parent != null)
					{
						build.append(",");

					}
				}
				// add the destination city
				build.append(String.format("%12s", n.getName()));
				// reverse the found path to the city to get Start->Destination
				solution.append(String.format("%-30s", build.reverse().toString()));
				// add the cost of the path
				solution.append(String.format("%10s", "$"+n.getCost()));
				// add the solution onto the arraylist
				paths.add(solution.toString());
				
				// reset stringbuilders
				build.setLength(0);
				solution.setLength(0);
			}
		}
		return paths;
	}

	/** Write the solution paths onto the file passed in
	 * 
	 * @param outputFile: Path to where the output file will be written
	 * @param map:Flightmap storing the graph represented in the input file
	 */
	private static void writeSolution(String outputFile, FlightMap map)
	{
		ArrayList<String> solutionStrings = reconstructSolution(map);
		try
		{
			PrintWriter pw = new PrintWriter(new FileWriter(outputFile));
			
			pw.println(String.format(SearchMap.OUTPUT_FILE_HEADER, map.findStartNode().getName()));
			// write solutions to the file
			for(String path: solutionStrings)
			{
				pw.println(path);
			}
			// close the file
			pw.flush();
			pw.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getLocalizedMessage());
		}
		catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
	}
		
	
	
};
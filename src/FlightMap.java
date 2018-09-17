import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class FlightMap
{
	private ArrayList<Node> flightMap;
	/** Overloaded constructor for FlightMap. Creates the flightmap.
	 * 
	 * @param inputFilename: String, filepath of the input file
	 */
	public FlightMap(String inputFilename)
	{
		try
		{
			parseFile(inputFilename);

		}
		catch(FileNotFoundException fnfe)
		{
			System.out.printf("File %s not found\nExiting program.\n", inputFilename);
			System.exit(-1);
		}
	}
	/** Wrapper function for Integer's parseInt function
	 * 
	 * @param costString: String that can be parsed as an integer
	 * @return Integer value, the cost of the flight between cities
	 */
	private static Integer getCost(String costString)
	{
		return Integer.parseInt(costString);
	}
	
	/** Access the ArrayList&lt;Node&gt; member variable
	 * 
	 * @return ArrayList&lt;Node&gt; storing all of the nodes ('cities')
	 */
	public ArrayList<Node> getFlightMap()
	{
		return this.flightMap;
	}
	
	/** Check the if a city is already on the map.
	 * 
	 * @param name: String, name of the city 
	 * @return Node: Null if the city is not on the map, otherwise the Node pointer
	 */
	private Node findNode(String name)
	{
		if(this.flightMap.isEmpty())
		{
			return null;
		}
		for(Node n: this.flightMap)
		{
			if(n.getName().equals(name))
			{
				return n;
			}
		}
		return null;
	}
	/**Searches the flightmap for the start city
	 * 
	 * @return Node corresponding to the start city of the flightmap
	 */
	public Node findStartNode()
	{
		for(Node n: flightMap)
		{
			if(n.isStartNode())
			{
				return n;
			}
		}
		return null;
	}
	/** Construct the FlightMap by parsing the input file and constructing the map and nodes
	 * 
	 * @param filename: String, the input file's filepath
	 * @throws FileNotFoundException
	 */ 
	private void parseFile(String filename) throws FileNotFoundException
	{
		try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String currLine = null;
            String homeCity = null;
            Node currCity = null;
            this.flightMap = new ArrayList<Node>();
            
            // read-in the home city
            homeCity = br.readLine();
            currCity = new Node(homeCity, true);
            this.flightMap.add(currCity);
            
            while((currLine = br.readLine()) != null)
            {
            	// parse the currline for the start node and
            	// destination node
            	String[] line = currLine.split(" ");
            	
            	// check if reading in an adj node of the curr city
            	if(line[0].equalsIgnoreCase(currCity.getName()))
            	{
            		// take the 2nd column of line as the destination node
            		// and 3rd column as the edge price between start and dest. node
            		Node node = findNode(line[1]);
            		if(node == null)
            		{
            			node = new Node(line[1], false);
            			this.flightMap.add(node);
            		}
            		currCity.addAdjacentNode(node, getCost(line[2]));
            	}
            	// new city
            	else
            	{
            		currCity = findNode(line[0]);
            		if(currCity == null)
            		{
            			currCity = new Node(line[0], false);
            			this.flightMap.add(currCity);
            		}
            		
            		// check if the adj city is already in nodes list
            		Node n = findNode(line[1]);
            		if(n != null)
            		{
            			currCity.addAdjacentNode(n, getCost(line[2]));
            		}
            		else // create new node
            		{
            			n = new Node(line[1], false);
            			currCity.addAdjacentNode(n, getCost(line[2]));
            			this.flightMap.add(n);
            		}
            	}
            }
            br.close();
        }
		catch(FileNotFoundException fnfe)
		{
			throw fnfe;
		}
        catch(IOException io)
        {
        	System.out.println(io.getMessage());
        }
	}
};
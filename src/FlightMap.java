import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FlightMap
{
	private ArrayList<Node> flightMap;
	/**
	 * 
	 * @param inputFilename
	 */
	public FlightMap(String inputFilename)
	{
		parseFile(inputFilename);
	}
	private static Integer getCost(String costString)
	{
		return Integer.parseInt(costString);
	}
	public ArrayList<Node> getFlightMap()
	{
		return this.flightMap;
	}
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

	/**
	 * 
	 * @param filename
	 * @return
	 */ 
	private void parseFile(String filename)
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
        }
        catch(IOException io)
        {
        	System.out.println(io.getMessage());
        }
	}
};
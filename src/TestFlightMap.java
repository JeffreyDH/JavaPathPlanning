import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
public class TestFlightMap
{
	private FlightMap map;
	private static final String INPUT_FILE = "input.txt";
	
	@Before
	public void setup()
	{
		System.out.printf("Current directory is %s\n", System.getProperty("user.dir"));
		this.map = new FlightMap(TestFlightMap.INPUT_FILE);
	}
    /**
     * Test the parsing of the input file.
     * Tests whether a map has been successfully created
     * Tests if the correct number of 'cities' have been read from the file
     */
    @Test
    public void TestMapCreation()
    {
    	Assert.assertTrue(map.getFlightMap() != null);
    	Assert.assertTrue(map.getFlightMap().size() == 9);
    }
    /**
     * Tests whether the cities have their correct outbound edges.
     * Nodes not responsible for storing their inbound edges
     */
    @Test
    public void TestFlightConnections()
    {
    	// Using the input given on the assignment requirements
    	for(Node n: map.getFlightMap())
    	{
    		switch(n.getName())
    		{
    			case "P":
    			case "Y":
    			case "W":
    				Assert.assertTrue(n.getAdjacentNodes().size() == 2);
    				break;
    			case "T":
    			case "Q":
    			case "R":
    			case "S":
    				Assert.assertTrue(n.getAdjacentNodes().size() == 1);
    				break;
    			case "X":
    			case "Z":
    				Assert.assertTrue(n.getAdjacentNodes().isEmpty());
    				break;
    				
    		}
    	}
    }
    @Test
    public void TestFindStartNode()
    {	
    	Assert.assertTrue(map.findStartNode().isStartNode());
    }

};
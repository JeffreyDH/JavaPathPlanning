import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class TestNode
{
	private ArrayList<String> testChars;
	private ArrayList<Node> testNodes;
	private Random rand;
	
	@Before
	public void setup()
	{
		// Generate the characters
		String upper = null;
		String lower = null;
		testChars = new ArrayList<String>();
		testNodes = new ArrayList<Node>();
		for(char i = 'A'; i <= 'Z'; ++i)
		{
			upper = Character.toString(i);
			testNodes.add(new Node(upper, false));
			testChars.add(upper);
			lower = Character.toString((char)(i+32));
			testNodes.add(new Node(lower, false));
			testChars.add(lower);
			
		}
		rand = new Random();
	}
	@Test
	public void TestGetName()
	{
		for(int i = 0; i < testChars.size(); ++i)
		{
			assertEquals(testNodes.get(i).getName(), testChars.get(i));
		}
	}
	@Test
	public void TestBooleanMemberVariables()
	{
		// testing false->true
		for(Node n: testNodes)
		{
			assertFalse(n.hasBeenVisited());
			n.visited();
			assertTrue(n.hasBeenVisited());
		}
	}
	
	@Test
	public void TestCost()
	{
		final Integer cost = 1000;
		Node n = new Node("1", false);
		n.setCost(cost);
		assertEquals(cost, n.getCost());
	}
	@Test
	public void TestParent()
	{
		Node parent = testNodes.get(rand.nextInt(testNodes.size()));
		Node child = testNodes.get(rand.nextInt(testNodes.size()));
		child.setParentNode(parent);
		assertEquals(child.getParentNode(), parent);
	}
	@Test
	public void TestAdjacentNode()
	{
		Node node = testNodes.get(rand.nextInt(testNodes.size()));
		ArrayList<Node> nodes = new ArrayList<Node>();
		for(int i = 0; i < 5; ++i)
		{
			Node adj = testNodes.get(rand.nextInt(testNodes.size()));
			node.addAdjacentNode(adj, i);
			nodes.add(adj);
		}
		// check that all nodes added
		for(Node n: nodes)
		{
			assertNotNull(node.getAdjacentNodes().get(n));
		}
	}
};
import java.util.HashMap;
public class Node
{
	/**
	 * Keep track of the node's string representation
	 */
    private String name;
    private Boolean isStartNode;
    private HashMap<Node, Integer> adjacentNodes;
    /**
     * 
     * @param name
     * @param isStart
     */
    public Node(String name, Boolean isStart)
    {
        this.name = name;
        this.isStartNode = isStart;
        this.adjacentNodes = new HashMap<Node, Integer>();
    }
    /**
     * 
     * @return
     */
    public String getName()
    {
        return this.name;
    }
    public Boolean isStartNode()
    {
    	return this.isStartNode;
    }
    /**
     * 
     * @param node
     * @param cost
     */
    public void addAdjacentNode(Node node, Integer cost)
    {
    	this.adjacentNodes.put(node, cost);
    }
    /**
     * 
     * @return
     */
    public HashMap<Node, Integer> getAdjacentNodes()
    {
    	return this.adjacentNodes;
    }
    
};
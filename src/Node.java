import java.util.HashMap;
public class Node
{
	/**
	 * Keep track of the node's string representation
	 */
    private String name;
    private Boolean isStartNode;
    private HashMap<Node, Integer> adjacentNodes;
    private Boolean visited;
    private Node parent;

    
    /**
     * 
     * @param name: String, name of the node as read-in from the input file
     * @param isStart: Boolean, whether the node is the start of the map
     */
    public Node(String name, Boolean isStart)
    {
        this.name = name;
        this.isStartNode = isStart;
        this.adjacentNodes = new HashMap<Node, Integer>();
        this.visited = false;
        this.parent = null;
    }
    /**Getter for the node's name
     * 
     * @return String, name member function
     */
    public String getName()
    {
        return this.name;
    }
    /** Sets member variable visited to True
     * 
     */
    public void visited()
    {
    	this.visited = true;
    }
    /** Returns value of the member variable visited
     * 
     * @return Boolean: True-Node has been visited before
     * 					False-Node has not been visited
     */
    public Boolean hasBeenVisited()
    {
    	return this.visited;
    }
    /**Check if the node is the start node
     * 
     * @return Boolean; true is node is start of map, otherwise false
     */
    public Boolean isStartNode()
    {
    	return this.isStartNode;
    }
    /**
     * 
     */
    public void setParentNode(Node pNode)
    {
    	this.parent = pNode;
    }
    /**
     * 
     * @return
     */
    public Node getParentNode()
    {
    	return this.parent;
    }
    /** Add adjacent node to the node's map
     * 
     * @param node: Node object 
     * @param cost: Cost of the edge 
     */
    public void addAdjacentNode(Node node, Integer cost)
    {
    	this.adjacentNodes.put(node, cost);
    }
    /** Getter for the node's map of adjacent nodes
     * 
     * @return HashMap&lt;Node, Integer&gt;, node's stored adjacent nodes
     */
    public HashMap<Node, Integer> getAdjacentNodes()
    {
    	return this.adjacentNodes;
    }
    
};
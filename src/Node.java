import java.util.HashMap;
public class Node
{
    private String name;
    private Boolean isStartNode;
    private HashMap<Node, Integer> adjacentNodes;
    private Boolean visited;
    private Node parent;
    private Integer cost;
    
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
        this.cost = 0;
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
    /** Sets the parent node, used in the solution reconstruction
     * @param pNode, node that will be the parent node
     */
    public void setParentNode(Node pNode)
    {
    	this.parent = pNode;
    }
    /** Get the node's parent node
     * 
     * @return Node corresponding to the parent node of this node
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
    /** Sets the cost to get to this node from the start node
     * @param cost Integer value 
     */
    public void setCost(Integer cost)
    {
    	this.cost = cost;
    }
    /** Get the cost to get to this node from the start node
     * 
     *@return Integer, flight cost
     */
    public Integer getCost()
    {
    	return this.cost;
    }
};
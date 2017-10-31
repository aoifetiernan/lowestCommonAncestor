
import java.util.*;




/**
 * Changes made to the node class to take into account that each node can have multiple children
 * Using a hash table 
*/
 class Node<T> 
 {
    T data;
    Set<Node<T>> adjacencyList;

    public Node(T data) 
    {
        this.data = data;
        this.adjacencyList = new HashSet<>();
    }

    public void addEdge(Node<T> v) 
    {
        adjacencyList.add(v);
    }
    
    
    public int sizeAdjList()
    {
    	return adjacencyList.size();
    }
}



public class LowestCommonAncestorDAG<Integer> 
{
	
    Node<Integer> root;
    
    public Node<Integer> LCA(Node<Integer> node1, Node<Integer> node2) 
    {
        if (root == null || node1 == null || node2 == null) 
        {
            return null;
        }
        if(node1==root || node2==root)
        {
        	return root;
        }
       
        	List<Node<Integer>> list1 = depthFirstSearch(root, node1, new ArrayList<>(), new Stack<>());  	
        	List<Node<Integer>> list2 = depthFirstSearch(root, node2, new ArrayList<>(), new Stack<>());
        	
        	if (list1 == null || list2 == null ) 
        	{
        		return null;
        	}
        	
        	List<Node<Integer>> smallList;
        	List<Node<Integer>> largeList;
        	
        	if (list1.size() <= list2.size()) 
        	{
        		smallList = list1;
        		largeList = list2;
        	} else {
        		smallList = list2;
        		largeList = list1;
        	}
        	
        	if(largeList.contains(node1))
        	{
        		return(node1);
        	}
        	
        	else if(largeList.contains(node2))
        	{
        		return(node2);
        	}
        	else
        	{

        		for (int i = largeList.size()-1; i >= 0; i--) 
        		{
        			if (smallList.contains(largeList.get(i))) 
        			{
        				return largeList.get(i);
        			}
        		}
        	}
        	return null;
    }
    
    
    
    
    
    
    

    private List<Node<Integer>> depthFirstSearch(Node<Integer> node, Node<Integer> targetNode, List<Node<Integer>> list, Stack<Node<Integer>> stack) 
    {
        stack.push(node);
        for (Node<Integer> n : node.adjacencyList) 
        {
            if (n.equals(targetNode)) 
            {
                list.addAll(stack);
                return list;
            }
            depthFirstSearch(n, targetNode, list, stack);
        }
        stack.pop();
        return list;
    }
    
    
    

}

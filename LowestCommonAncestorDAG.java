
import java.util.*;




/*
 Changes made to the node class to take into account that each node can have multiple children. Implemented using a hash table 
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
    
    
}



public class LowestCommonAncestorDAG<Integer> 
{
	
    Node<Integer> root;
    Set<Node<Integer>> allNodes;
    
    
    
  //Constructor to initialize the LowestCommonAncestorDAG class
    public LowestCommonAncestorDAG()
    {
    	allNodes = new HashSet<>();
    }
    
    
    //Method which creates a node and adds it to the set of nodes in the DAG
    public Node<Integer> createNode(Integer data)
    {
    	Node<Integer> node = new Node<Integer>(data);
    	allNodes.add(node);
    	return node;  	
    }
    
    
    
    //Checks if a list (produced using dfs algorithm) contains duplicate elements. If so indicates a cycle
    public boolean duplicateElements(List<Node<Integer>> list)
    {
    	Set<Node<Integer>> set = new HashSet<Node<Integer>>(list);

    	if(set.size() < list.size())
    	{
    	    return true;
    	}
    	else return false;
    	
    }
    
    
    //Returns the lowest common ancestor of the two parameterized nodes
    public Node<Integer> LCA(Node<Integer> node1, Node<Integer> node2) 
    {

        if (root == null || node1 == null || node2 == null) 
        {
            return null;
        }
        if((node1==root && allNodes.contains(node2)) || (allNodes.contains(node1) && node2==root)  || (node1==root && node2==root))
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
        	
        	if(duplicateElements(list1) || duplicateElements(list2))
        	{
        		return null;
        	}
        	
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
    
    

    //DFS traversal from a given node to a target node. Returned as a list of nodes
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

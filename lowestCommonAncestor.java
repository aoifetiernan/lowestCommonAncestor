/**
 * Changes made to the node class to take into account that each node can have multiple children
 * Using a hash table 
*/

  class DAGNode<Integer> 
 {
    int data;
    Set<DAGNode<Integer>> adjacent;

    public DAGNode(int data) 
    {
        this.data = data;
        this.adjacent = new HashSet<>();
    }

    public void addEdge(DAGNode<Integer> edgeData) 
    {
        adjacent.add(edgeData);
    }
}
 
 
 //Binary Tree data type
 class lowestCommonAncestor
 {
     public BTNode root;
 
     
     public lowestCommonAncestor()
     {
         root = null;
     }
     

     
     //Function to find the Lowest Common Ancestor of two nodes
     public BTNode LCA(BTNode root, BTNode p, BTNode q) 
     {
    	    if(root==null || p==null || q == null)
    	    {
    	    	return null;
    	    }
    	        
    	 
    	    if(root==p || root==q)
    	    {
    	        return root;
    	    }
    	 
    	    BTNode l = LCA(root.left, p, q);
    	    BTNode r = LCA(root.right, p, q);
    	 
    	    if(l!=null&&r!=null)
    	    {
    	        return root;
    	    }else if(l==null&&r==null)
    	    {
    	        return null;
    	    }else
    	    {
    	        return l==null?r:l;
    	    }
    }
     
     
     
         
}

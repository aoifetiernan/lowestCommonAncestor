

 class BTNode
 {    
     BTNode left, right;
     int data;
 
    
     
     public BTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
    
     
     public BTNode(int n)
     {
         left = null;
         right = null;
         data = n;
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

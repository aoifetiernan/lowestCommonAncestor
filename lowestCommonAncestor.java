

 class BTNode
 {    
     BTNode left, right;
     int data;
 
     /* Constructor */
     public BTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     /* Constructor */
     public BTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     /* Function to set left node */
     public void setLeft(BTNode n)
     {
         left = n;
     }
     /* Function to set right node */ 
     public void setRight(BTNode n)
     {
         right = n;
     }
     /* Function to get left node */
     public BTNode getLeft()
     {
         return left;
     }
     /* Function to get right node */
     public BTNode getRight()
     {
         return right;
     }
     /* Function to set data to node */
     public void setData(int d)
     {
         data = d;
     }
     /* Function to get data from node */
     public int getData()
     {
         return data;
     }     
 }
 
 /* Class BT */
 class lowestCommonAncestor
 {
     public BTNode root;
 
     /* Constructor */
     public lowestCommonAncestor()
     {
         root = null;
     }
     
     
     
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     
     
     /* Functions to insert data */
     public void insert(int data)
     {
         root = insert(root, data);
     }
     
     
     /* Function to insert data recursively */
     private BTNode insert(BTNode node, int data)
     {
         if (node == null)
             node = new BTNode(data);
         else
         {
             if (node.getLeft() == null)
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);             
         }
         return node;
     }     
     
     
 
     public BTNode LCA(BTNode root, BTNode p, BTNode q) 
     {
    	    if(root==null || p==null || q == null)
    	        return null;
    	 
    	    if(root==p || root==q)
    	        return root;
    	    
    	 
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
     
     
     
     /* Function to search for an element */
     public boolean search(int val)
     {
         return search(root, val);
     }
     /* Function to search for an element recursively */
     private boolean search(BTNode r, int val)
     {
         if (r.getData() == val)
             return true;
         if (r.getLeft() != null)
             if (search(r.getLeft(), val))
                 return true;
         if (r.getRight() != null)
             if (search(r.getRight(), val))
                 return true;
         return false;         
     }
     
     
     
     public void postorder()
     {
         postorder(root);
     }
     
     private void postorder(BTNode r)
     {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }    
}

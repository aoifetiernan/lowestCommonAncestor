import static org.junit.Assert.*;

import org.junit.Test;

public class lowestCommonAncestorTest {


	
	//test cases for an empty binary tree.
	@Test
	public void testEmptyBT()
	{
		lowestCommonAncestor binaryTree = new lowestCommonAncestor();
		
		// test it returns null for the LCA of an empty BT, where root has not been defined 
		assertNull(binaryTree.LCA(binaryTree.root, null, null));
		
		//test it returns null for an empty BT where root has been defined, but has not been given a value
		binaryTree.root = new BTNode();
		BTNode r = binaryTree.root;
		assertNull(binaryTree.LCA(r, r.left, r.right));
	}
	
	
	
	
	//test cases for a Binary Tree with a single Node (root).
	@Test
	public void testOneNodeBT()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.root = new BTNode(12);
		
		//test it returns equals for the LCA when both of the passed in nodes are the root
		assertEquals(BT.LCA(BT.root, BT.root, BT.root), BT.root);
		
		//test it returns null if finding the LCA of single node tree and the passed in nodes are not the root
		assertNull(BT.LCA(BT.root, BT.root.right, BT.root.left));
	}
	
	
	
	
	//test cases for a two node Binary Tree. 
	@Test
	public void testTwoNodeBT()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.root = new BTNode(4);
		BT.root.left = new BTNode(2);
		BTNode r = BT.root;
		
		//test it returns the root node when finding the LCA of the only two nodes in the BT.  
		assertEquals(BT.LCA(r, r.left, r), r);
		
		//test it returns null when a node that has not been defined is parameterized.  
		assertNull(BT.LCA(r, r.left, r.right));
	}
	
	
	
	
	
	
	
	
	//This test ensures null is returned if we are asked to find the LCA of two values that are not present 
	//in the BT. 
	@Test 
	public void testInvalidElements()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.root = new BTNode(5);
		BT.root.left = new BTNode(9);
		BT.root.right = new BTNode(11);
		BT.root.left = new BTNode(9);
		BT.root.left.left = new BTNode(11);
		BTNode r = BT.root;

		//Only one of the nodes we are finding the LCA of is defined in the Binary Tree
		assertNull(BT.LCA(r, r.left, null));
		assertNull(BT.LCA(r, null, r.right));
	}
	
	
	
	

	//Test case for finding the LCA when the two nodes have the same parent node.
	@Test
	public void testNodesWithSameParent()
	{
	
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.root = new BTNode(5);
		BT.root.left = new BTNode(9);
		BT.root.right = new BTNode(11);
		BT.root.left.left = new BTNode(14);
		BT.root.left.right = new BTNode(36);
		BT.root.right.left = new BTNode(61);
		BT.root.right.right = new BTNode(19);
		
		BTNode leftParent = BT.root.left;
		BTNode rightParent = BT.root.right;
		
		//Test case where the root is the LCA
		assertEquals(BT.LCA(BT.root, BT.root.left, BT.root.right), BT.root);
		
		//Test Case where the left child of the root is the LCA
		assertEquals(BT.LCA(BT.root, leftParent.left, leftParent.right), leftParent);
		
		//Test Case where the right child of the root is the LCA
		assertEquals(BT.LCA(BT.root, rightParent.left, rightParent.right), rightParent);
		
	}
	
	
	//Testing other LCA scenarios in larger binary trees. 
	@Test
	public void otherTestCases()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.root = new BTNode(5);
		BT.root.left = new BTNode(9);
		BT.root.right = new BTNode(11);
		BT.root.left.left = new BTNode(14);
		BT.root.left.right = new BTNode(36);
		BT.root.right.left = new BTNode(61);
		BT.root.right.right = new BTNode(19);
		
		BTNode r = BT.root;
		BTNode leftParent = BT.root.left;
		BTNode rightParent = BT.root.right;
		
		//Ensure LCA of far left and right nodes is the root 
		assertEquals(BT.LCA(r, leftParent.left, rightParent.right),r);
		
		//Ensure the LCA of a parent and child Node returns the parent Node
		assertEquals(BT.LCA(r, leftParent, leftParent.right), leftParent);
		
	}
	
	
	
	
	
	
	

}
	



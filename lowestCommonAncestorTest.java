import static org.junit.Assert.*;

import org.junit.Test;

public class lowestCommonAncestorTest {


	
	//test it returns null for the LCA of an empty BT
	@Test
	public void testEmptyBT()
	{
		lowestCommonAncestor binaryTree = new lowestCommonAncestor();
		assertNull(binaryTree.LCA(binaryTree.root, null, null));		
	}
	
	
	
	
	//test cases for a Binary Tree with a single Node (root)
	@Test
	public void testOneNodeBT()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.insert(34);
		
		//test it returns equals for the LCA when both of the passed in values are the root
		assertEquals(BT.LCA(BT.root, BT.root, BT.root), BT.root);
		
		//test it returns null if finding the LCA of single node tree and the values are not the root
		assertEquals(BT.LCA(BT.root, null, BT.root),BT.root);
	}
	
	
	
	
	//test cases for a two node Binary Tree 
	@Test
	public void testTwoNodeBT()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.insert(4);
		BT.insert(2);
		BTNode r = BT.root;
		
		//test it returns the root node in a BT with only two nodes 
		assertEquals(BT.LCA(r, r.left, r.right), r);
	}
	
	
	
	
	
	
	//This test ensures null is returned if we are asked to find the LCA of two values that are not present 
	//in the BT. 
	@Test 
	public void testInvalidElements()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.insert(5);
		BT.insert(9);
		BT.insert(11);
		BT.insert(1);
		BTNode r = BT.root;
		
		//no elements in BT
		assertNull(BT.LCA(r, null, null));
		
		//Only one element in BT
		assertNull(BT.LCA(r, r.left, null));
		assertNull(BT.LCA(r, null, r.right));
	}
	
	
	
	

	
	@Test
	public void testNodesWithSameParent()
	{
	
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.insert(5);
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
	
	
	
	
	

}
	


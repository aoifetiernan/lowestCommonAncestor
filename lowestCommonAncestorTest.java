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
		assertNull(BT.LCA(BT.root, 4, 2));
		
		//Only one element in BT
		assertNull(BT.findLca(BT.root, 9, 2));
		assertNull(BT.findLca(BT.root, 6, 11));
	}
	
	
	
	
	//Test case for situations when the LCA of two values is their parent node
	//@Test
	/*public void testNodesWithSameParent()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.insert(5);
		BT.root.left = new BTNode(9);
		BT.root.right = new BTNode(11);
		BT.root.left.left = new BTNode(14);
		BT.root.left.right = new BTNode(36);
		BT.root.right.left = new BTNode(61);
		BT.root.right.right = new BTNode(19);

		
		//System.out.println(BT.root.getData() + " " + BT.root.left.getData() + "  " + BT.root.right.getData());
		BTNode leftParent = BT.root.left;
		BTNode rightParent = BT.root.right;
		//System.out.println(leftParent.left.getData()  + " " + leftParent.right.getData());
		//System.out.println(rightParent.left.getData()  + " " + rightParent.right.getData());
		
		
		System.out.println(BT.findLca(BT.root, 9, 11).getData());
		System.out.println(BT.findLca(BT.root, 14, 36).getData());
		System.out.println(BT.findLca(BT.root, 61, 19).getData());
		
		assertEquals(BT.findLca(BT.root, 9, 11), BT.root);
		assertEquals(BT.findLca(BT.root, 14, 36), leftParent);
		assertEquals(BT.findLca(BT.root, 61, 19), rightParent);
	}
	*/
	
	@Test
	public void testNodesWithSameParent2()
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
		
		assertEquals(BT.LCA(BT.root, BT.root.left, BT.root.right), BT.root);
		assertEquals(BT.LCA(BT.root, leftParent.left, leftParent.right), leftParent);
		assertEquals(BT.LCA(BT.root, rightParent.left, rightParent.right), rightParent);
		
	}
	
	
	@Test
	public void testFind()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.insert(5);
		BT.root.left = new BTNode(9);
		BT.root.right = new BTNode(11);
		BT.root.left.left = new BTNode(14);
		BT.root.left.right = new BTNode(36);
		BT.root.right.left = new BTNode(61);
		
		System.out.println(BT.find(9).getData());
		System.out.println(BT.find(14).getData());
		System.out.println(BT.find(3).getData());
		assertEquals(BT.find(9), BT.root);
		assertEquals(BT.find(14), BT.root.left.left);
		assertNull(BT.find(3));
	}

}
	



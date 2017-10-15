import static org.junit.Assert.*;

import org.junit.Test;

public class lowestCommonAncestorTest {


	
	//test it returns null for the LCA of an empty BT
	@Test
	public void testEmptyBT()
	{
		lowestCommonAncestor binaryTree = new lowestCommonAncestor();
		assertNull(binaryTree.findLca(binaryTree.root, 0, 1));
		
		
	}
	
	
	//test it returns null for a BT with only a single node (root)
	@Test
	public void testOneNodeBT()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.insert(34);
		assertEquals(BT.findLca(BT.root, 34, 34), BT.root);
		assertNull(BT.findLca(BT.root, 34, 25));
	}
	
	
	//test it returns the root node in a BT with only two nodes 
	@Test
	public void testTwoNodeBT()
	{
		lowestCommonAncestor BT = new lowestCommonAncestor();
		BT.insert(4);
		BT.insert(2);
		assertEquals(BT.findLca(BT.root, 4, 2), BT.root);
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
		
		//no elements in BT
		assertNull(BT.findLca(BT.root, 4, 2));
		
		//Only one element in BT
		assertNull(BT.findLca(BT.root, 9, 2));
		assertNull(BT.findLca(BT.root, 6, 11));
	}
	

}
	



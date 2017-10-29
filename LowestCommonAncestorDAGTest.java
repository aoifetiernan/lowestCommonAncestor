import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorDAGTest {

	
	//Testing the node class method to add an edge between two vertices (nodes)
	@Test 
	public void testNodeAddEdge()
	{
		Node<Integer> n1 = new Node<Integer>(4);
		Node<Integer> n2 = new Node<Integer>(7);
		n1.addEdge(n2);
		assertEquals(n1.sizeAdjList(), 1);
		assertTrue(n1.adjacencyList.contains(n2));
	}
	

	
	//test cases for an empty DAG with no vertices.
		@Test
		public void testEmptyDAG()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();
			Node<Integer> n1 = new Node<Integer>(3);
			Node<Integer> n2 = new Node<Integer>(7);
			assertNull(DAG.LCA(n1, n2));			
		}
		
		
		
		
		//test cases for a DAG with a single Node/vertice (root).
		@Test
		public void testOneNodeDAG()
		{
			
		}
		
		
		
		
		//test cases for a two node DAG. 
		@Test
		public void testTwoNodeDAG()
		{
			
		}
		
		
		
		
		
		
		
		
		//This test ensures null is returned if we are asked to find the LCA of two values that are not present 
		//in the DAG. 
		@Test 
		public void testInvalidElements()
		{
			
		}
		
		
		
		

		//Test case for finding the LCA when the two nodes have the same parent node.
		@Test
		public void testNodesWithSameParent()
		{
		
			
			
		}
		
		
		
		
		
		//Testing other LCA scenarios in larger DAG. 
		@Test
		public void otherTestCases()
		{
			
		}
		

}

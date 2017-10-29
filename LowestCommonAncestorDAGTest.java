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
	

	
	//test cases for an empty DAG with no nodes.
		@Test
		public void testEmptyDAG()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();
			Node<Integer> n1 = new Node<Integer>(3);
			Node<Integer> n2 = new Node<Integer>(7);
			assertNull(DAG.LCA(n1, n2));
			
		}
		
		
		
		
		//test cases for a DAG with a single Node(root).
		@Test
		public void testOneNodeDAG()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();	
			DAG.root = new Node<Integer>(5);
			assertEquals(DAG.LCA(DAG.root, DAG.root), DAG.root);
			
			Node<Integer> n1 = new Node<Integer>(3);
			assertNull(DAG.LCA(DAG.root, n1));
		}
		
		
		
		
		//test cases for a two node DAG. 
		@Test
		public void testTwoNodeDAG()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();	
			DAG.root = new Node<Integer>(5);
			Node<Integer> n1 = new Node<Integer>(3);
			DAG.root.addEdge(n1);
			assertEquals(DAG.LCA(DAG.root, n1), DAG.root);
		}
		
		
		
		
		
		
		
		
		//This test ensures null is returned if we are asked to find the LCA of two values that are not present 
		//in the DAG. 
		@Test 
		public void testInvalidElements()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();	
			DAG.root = new Node<Integer>(5);
			Node<Integer> n1 = new Node<Integer>(3);
			Node<Integer> n2 = new Node<Integer>(9);
			DAG.root.addEdge(n1);
			DAG.root.addEdge(n2);
			assertNull(DAG.LCA( n1, null));
			assertNull(DAG.LCA(null, DAG.root));
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
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();	
			DAG.root = new Node<Integer>(5);
			Node<Integer> n1 = new Node<Integer>(3);
			Node<Integer> n2 = new Node<Integer>(5);
			Node<Integer> n3 = new Node<Integer>(7);
			Node<Integer> n4 = new Node<Integer>(2);
			DAG.root.addEdge(n1);
			DAG.root.addEdge(n2);
			DAG.root.addEdge(n3);
			DAG.root.addEdge(n4);
			assertEquals(DAG.LCA(n1, n2), DAG.root);
			
		}
		

}

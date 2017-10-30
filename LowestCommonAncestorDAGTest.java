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
			//assertNull(DAG.LCA(DAG.root, n1));
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
		
		
		/**	Sample DAG cases to be tested
		 * 
		 * 
		 * 	DAG1
		 * 			2
		 * 		  /   \
		 * 		 4	    9
		 * 		/|     /|\
		 * 	  11 |    3 8 21
		 * 	     |
		 * 		16
		 * 
		 * 
		 * DAG2
		 *  
		 * 
		 */
		
		
		//Testing other LCA scenarios in larger DAG. 
		@Test
		public void otherTestCases()
		{
			//DAG1
			LowestCommonAncestorDAG<Integer> DAG1 = new LowestCommonAncestorDAG<Integer>();	
			DAG1.root = new Node<Integer>(2);
			Node<Integer> n1 = new Node<Integer>(4);
			Node<Integer> n2 = new Node<Integer>(9);
			Node<Integer> n3 = new Node<Integer>(11);
			Node<Integer> n4 = new Node<Integer>(3);
			Node<Integer> n5 = new Node<Integer>(8);
			Node<Integer> n6 = new Node<Integer>(21);
			Node<Integer> n7 = new Node<Integer>(16);
			DAG1.root.addEdge(n1);
			DAG1.root.addEdge(n2);
			n1.addEdge(n3);
			n1.addEdge(n7);
			n2.addEdge(n4);
			n2.addEdge(n5);
			n2.addEdge(n6);
			assertEquals(DAG.LCA(n4, n5), n2);
			assertEquals(DAG.LCA(n1, n3), n1);			
			assertEquals(DAG.LCA(n1, n7), n1);
			
			
			
			//DAG2
			LowestCommonAncestorDAG<Integer> DAG2 = new LowestCommonAncestorDAG<Integer>();	
			DAG2.root = new Node<Integer>(2);
		}
		

}

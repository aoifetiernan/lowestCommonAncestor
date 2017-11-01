import static org.junit.Assert.*;

import java.util.*;

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
	
	
	//Testing when asked to find the LCA of a cyclical graph it returns null
	/**
	 * 
	 * cyclical DiGraph:
	 * 			9
	 * 		   / \		
	 * 		 22   17
	 * 		  \   /
	 * 			3	
	 * 

	 */
	@Test
	public void testAcyclical()
	{
		LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();
		Node<Integer> n1 = DAG.createNode(9);
		Node<Integer> n2 = DAG.createNode(22);
		Node<Integer> n3 = DAG.createNode(17);
		Node<Integer> n4 = DAG.createNode(3);
		DAG.root = n1;
		DAG.root.addEdge(n2);
		DAG.root.addEdge(n3);
		n2.addEdge(n4);
		n3.addEdge(n4);
		assertNull(DAG.LCA(n4, n2));
	
	}
	

	
	//test cases for an empty DAG with no nodes.
		@Test
		public void testEmptyDAG()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();
			Node<Integer> n1 = DAG.createNode(3);
			Node<Integer> n2 = DAG.createNode(7);
			assertNull(DAG.LCA(n1, n2));
			assertNull(DAG.LCA(DAG.root, DAG.root));
			
		}
		
		
		
		
		//test cases for a DAG with a single Node(root).
		@Test
		public void testOneNodeDAG()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();	
			DAG.root = DAG.createNode(5);
			assertEquals(DAG.LCA(DAG.root, DAG.root), DAG.root);
			
			Node<Integer> n1 = new Node<Integer>(3);
			assertNull(DAG.LCA(DAG.root, n1));
		}
		
		
		
		
		//test cases for a two node DAG. 
		@Test
		public void testTwoNodeDAG()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();	
			DAG.root = DAG.createNode(5);
			Node<Integer> n1 = DAG.createNode(3);
			DAG.root.addEdge(n1);
			assertEquals(DAG.LCA(DAG.root, n1), DAG.root);
		}
		
		
		
		
		
		
		
		
		//This test ensures null is returned if we are asked to find the LCA of two values that are not present 
		//in the DAG. 
		@Test 
		public void testInvalidElements()
		{
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();	
			DAG.root = DAG.createNode(5);
			Node<Integer> n1 = DAG.createNode(3);
			Node<Integer> n2 = DAG.createNode(9);
			DAG.root.addEdge(n1);
			assertNull(DAG.LCA( n1, null));
			assertNull(DAG.LCA(null, DAG.root));
			assertNull(DAG.LCA(n1, n2));
			
		}
		
		
		/**
		 * 	DAG for below test case:
		 * 
		 * 		    5	
		 * 		  /   \
		 * 		3	    9
		 * 	  /  \
		 *   11   6
		 */

		//Test case for finding the LCA when the two nodes have the same parent node.
		@Test
		public void testNodesWithSameParent()
		{
		
			LowestCommonAncestorDAG<Integer> DAG = new LowestCommonAncestorDAG<Integer>();	
			DAG.root = DAG.createNode(5);
			Node<Integer> n1 = DAG.createNode(3);
			Node<Integer> n2 = DAG.createNode(9);
			Node<Integer> n3 = DAG.createNode(11);
			Node<Integer> n4 = DAG.createNode(6);
			DAG.root.addEdge(n1);
			DAG.root.addEdge(n2);
			n1.addEdge(n3);
			n1.addEdge(n4);
			
			assertEquals(DAG.LCA(n1, n2), DAG.root);
			assertEquals(DAG.LCA(n3, n4),n1);
			
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
		 *  DAG2
		 *  
		 * 		19
		 * 		 |
		 * 		 4
		 * 		/ \
		 * 	   7   13
		 * 	  		| \
		 * 			|   6
		 * 			27
		 * 
		 * 
		 *  
		 *  DAG3
		 *  
		 *  1 - 12 - 14 - 2 - 21
		 *  |   	  \
		 *  6		  13 - 72
		 */			
		 
		
		
		//Testing other LCA scenarios in larger DAG. 
		@Test
		public void otherTestCases()
		{
			//DAG1
			LowestCommonAncestorDAG<Integer> DAG1 = new LowestCommonAncestorDAG<Integer>();	
			DAG1.root = new Node<Integer>(2);
			Node<Integer> n1 = DAG1.createNode(4);
			Node<Integer> n2 = DAG1.createNode(9);
			Node<Integer> n3 = DAG1.createNode(11);
			Node<Integer> n4 = DAG1.createNode(3);
			Node<Integer> n5 = DAG1.createNode(8);
			Node<Integer> n6 = DAG1.createNode(21);
			Node<Integer> n7 = DAG1.createNode(16);
			DAG1.root.addEdge(n1);
			DAG1.root.addEdge(n2);
			n1.addEdge(n3);
			n1.addEdge(n7);
			n2.addEdge(n4);
			n2.addEdge(n5);
			n2.addEdge(n6);
			assertEquals(DAG1.LCA(n4, n5), n2);
			assertEquals(DAG1.LCA(n1, n3), n1);			
			assertEquals(DAG1.LCA(n1, n7), n1);
			
			
			
			//DAG2
			LowestCommonAncestorDAG<Integer> DAG2 = new LowestCommonAncestorDAG<Integer>();	
			DAG2.root = DAG2.createNode(19);
			Node<Integer> node1 = DAG2.createNode(4);
			Node<Integer> node2 = DAG2.createNode(7);
			Node<Integer> node3 = DAG2.createNode(13);
			Node<Integer> node4 = DAG2.createNode(27);
			Node<Integer> node5 = DAG2.createNode(6);

			DAG2.root.addEdge(node1);
			node1.addEdge(node2);
			node1.addEdge(node3);
			node3.addEdge(node4);
			node3.addEdge(node5);
			assertEquals(DAG2.LCA(node2, node5), node1);
			assertEquals(DAG2.LCA(node3, node4), node3);			
			assertEquals(DAG2.LCA(node4, node5), node3);
			
			
			
			//DAG3
			LowestCommonAncestorDAG<Integer> DAG3 = new LowestCommonAncestorDAG<Integer>();	
			DAG3.root = new Node<Integer>(1);
			Node<Integer> x1 = DAG3.createNode(12);
			Node<Integer> x2 = DAG3.createNode(94);
			Node<Integer> x3 = DAG3.createNode(2);
			Node<Integer> x4 = DAG3.createNode(21);
			Node<Integer> x5 = DAG3.createNode(6);
			Node<Integer> x6 = DAG3.createNode(13);
			Node<Integer> x7 = DAG3.createNode(72);
			DAG3.root.addEdge(x1);
			DAG3.root.addEdge(x5);
			x1.addEdge(x2);
			x2.addEdge(x3);
			x2.addEdge(x6);
			x3.addEdge(x4);
			x6.addEdge(x7);
			
			assertEquals(DAG3.LCA(x4, x7),x2);
			assertEquals(DAG3.LCA(x5, x3),DAG3.root);
			
			
		}
		

}

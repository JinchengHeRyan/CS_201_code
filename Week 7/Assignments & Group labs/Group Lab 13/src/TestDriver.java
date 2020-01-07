public class TestDriver {
	public static void main(String[] args) {
		// The following inserts are all in order, creating a completely unbalanced tree
		BinaryTreeNode<Double> tree = BinaryTreeNode.put(null, 6.0, "1");
		
		// BinaryTreeNode.put(tree, 2.0, "2");
		// BinaryTreeNode.put(tree, 3.0, "3");
		// BinaryTreeNode.put(tree, 4.0, "4");
		// BinaryTreeNode.put(tree, 5.0, "5");

		BinaryTreeNode.put(tree, 4.0, "2");
		BinaryTreeNode.put(tree, 8.0, "3");
		BinaryTreeNode.put(tree, 3.0, "4");
		BinaryTreeNode.put(tree, 5.0, "5");
		BinaryTreeNode.put(tree, 7.0, "6");
		BinaryTreeNode.put(tree, 2.0, "7");
		BinaryTreeNode.put(tree, 1.0, "4");
		// BinaryTreeNode.put(tree, 5.0, "5");

		// The following insert is out of order
		// BinaryTreeNode.put(tree, 0.5, "1/2");

		// Look up 4.0 in the tree
		System.out.println("get 4.0 = " + BinaryTreeNode.get(tree, 4.0));

		// Do an inorder walk and print the keys (will be in alphabetical order)
		tree.printInorder();

		// Print the whole tree out
		tree.printTree(0);
		
		// check whether it is a heap or not
		tree.heapOrdered();
		System.out.println(tree.heapOrdered());

		// check if it is balanced
		tree.balanced();
		System.out.println(tree.balanced());
	}
}
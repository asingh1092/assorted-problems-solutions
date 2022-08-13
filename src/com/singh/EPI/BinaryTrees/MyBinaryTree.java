package src.com.singh.EPI.BinaryTrees;

public class MyBinaryTree<T> {
	
	private MyBinaryTreeNode<T> root;
	
	public MyBinaryTree() {
		this.root = null;
	}
	
	public MyBinaryTree(T data) {
		root = new MyBinaryTreeNode<T>(data);
	}
	
	public boolean isEmpty() {
		return root == null;
	}

	public MyBinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(MyBinaryTreeNode<T> root) {
		this.root = root;
	}
	
	// bunch of methods like
	// traversal (in order / pre order / post order)
	// search
	// add children
	// etc

}

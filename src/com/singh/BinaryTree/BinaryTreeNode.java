package src.com.singh.BinaryTree;

public class BinaryTreeNode {

    public BinaryTreeNode left = null;
    public BinaryTreeNode right = null;
    public int data;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}

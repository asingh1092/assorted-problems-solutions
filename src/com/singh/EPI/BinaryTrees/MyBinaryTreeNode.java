package src.com.singh.EPI.BinaryTrees;

public class MyBinaryTreeNode<T> {

    private T data;
    private MyBinaryTreeNode<T> left;
    private MyBinaryTreeNode<T> right;
    private MyBinaryTreeNode<T> parent;

    public MyBinaryTreeNode() {
        this.data = null;
        left = null;
        right = null;
    }

    public MyBinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyBinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(MyBinaryTreeNode<T> left) {
        this.left = left;
    }

    public MyBinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(MyBinaryTreeNode<T> right) {
        this.right = right;
    }

    public MyBinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(MyBinaryTreeNode<T> parent) {
        this.parent = parent;
    }

}

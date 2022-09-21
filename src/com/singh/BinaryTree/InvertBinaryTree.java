package src.com.singh.BinaryTree;

public class InvertBinaryTree {

    /*
        n-inary tree: max of n children per node
        binary tree: max of 2 children per node
        Complete: a binary tree in which every level except possibly the last is completely filled and all nodes in the last level are as far left as possible
        Balanced: a binary tree structure in which the left and right subtrees of every node differ in height by no more than 1
        in-order traversal: left -> root -> right
        pre-order traversal: root -> left -> right
        post-order traversal: left -> right -> root
        BST (binary search tree):
            - left subtree of a node contains only nodes with keys lesser than the node's key
            - right subtree of a node contains only nodes with keys greater than the node's key
            - left and right subtree each must also be binary search tree


                4                   4
              /   \               /   \
             2     7     ->      7    2
            / \   / \           / \  / \
           1  3  6   9         9  6  3  1
     */

    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode left = invertTree(root.left);
        BinaryTreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(
                new BinaryTreeNode(new BinaryTreeNode(1), new BinaryTreeNode(3), 2),
                new BinaryTreeNode(new BinaryTreeNode(6), new BinaryTreeNode(9), 7),
                4
        );
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        System.out.println(invertBinaryTree.invertTree(root));

    }
}

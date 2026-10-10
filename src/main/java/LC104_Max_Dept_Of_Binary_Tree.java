/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
class LC104_Max_Dept_Of_Binary_Tree {
    //LC: 104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        // What does my function return for a null node?

        int findDepth=recursiveMaxDepth(root);
        // What does it return for a leaf?

        // How do I combine the answers from the left and right children?
        return findDepth;
    }

    public int recursiveMaxDepth(TreeNode root){

        if(root == null){
            return 0;
        }
        else return (Math.max(recursiveMaxDepth(root.left), recursiveMaxDepth(root.right))+1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

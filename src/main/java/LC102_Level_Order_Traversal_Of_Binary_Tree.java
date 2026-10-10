import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class LC102_Level_Order_Traversal_Of_Binary_Tree {
    //LC: 102. Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> finalOutput=new ArrayList<>();
        if(root==null){
            return new ArrayList<List<Integer>>();
        }

        Queue<TreeNode> listToVisit=new ArrayDeque<>();
        listToVisit.add(root);

        while(!listToVisit.isEmpty()){
            ArrayList<Integer> levelElements = new ArrayList<Integer>();
            int level= listToVisit.size();
            for(int i=0;i<level;i++){
                TreeNode poll = listToVisit.poll();
                levelElements.add(poll.val);
                if(poll.left!=null){
                    listToVisit.add(poll.left);
                }
                if(poll.right!=null){
                    listToVisit.add(poll.right);
                }
            }
            finalOutput.add(levelElements);
        }

        return finalOutput;
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

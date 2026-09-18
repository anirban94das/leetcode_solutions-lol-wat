import java.util.LinkedList;
import java.util.Queue;
// Node Structure
public class Tree_Traversal {
    static int height(Node root) {
        if (root == null) return 0;
        // Representation of the input tree:
        //     12
        //    /  \
        //   8    18
        //  / \    \
        // 5   11   9
        // Initializing a queue to traverse
        // the tree level by level
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        // Loop until the queue is empty
        while (!q.isEmpty()) {
            int levelSize = q.size();


            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node curr = q.poll();

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);

                System.out.println(curr.data);
            }

            // Increment height after traversing each level
            depth++;
        }
        return depth - 1;
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //     12
        //    /  \
        //   8    18
        //  / \    \
        // 5   11   9
        Node root = new Node(12);
        root.left = new Node(8);
        root.right = new Node(18);
        root.left.left = new Node(5);
        root.left.right = new Node(11);
        root.right.right=new Node(9);

        System.out.println(height(root));
    }
}
class Node {

    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}


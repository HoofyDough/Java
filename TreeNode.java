import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(Integer[] x) {
        TreeNode head = generateTreeNodes(x);
        this.val = head.val;
        this.left = head.left;
        this.right = head.right;
    }

    public TreeNode generateTreeNodes(Integer[] vals) {
        return createTreeFromQueue(new LinkedList<Integer>(Arrays.asList(vals)));
    }

    public TreeNode createTreeFromQueue(Queue<Integer> queue) {
        TreeNode treeNode = null;
        if(!queue.isEmpty()) {
            Integer val = queue.poll();
            treeNode = new TreeNode(val);
            treeNode.left = createTreeFromQueue(queue);
            treeNode.right = createTreeFromQueue(queue);
        }
        return treeNode;
    }

    public void printTreeNodes(TreeNode l1, String place) {
        if(l1 != null) {
            System.out.print(place + ": " + l1.val + ", ");
            printTreeNodes(l1.left, "Left");
            printTreeNodes(l1.right, "Right");
        } else {
            System.out.print("null; ");
        }
    }
}
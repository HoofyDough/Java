class BinaryTreeMaxPathSum {
	int max = 0;

	public int maxPathSum(TreeNode root) {
        max = root.val;
        flpRecursive(root);
		return max;
	}

	private int flpRecursive(TreeNode node) {
		if(node == null)
			return 0;
		int leftVal = Math.max(0,flpRecursive(node.left));
		int rightVal = Math.max(0,flpRecursive(node.right));
		max = Math.max(max, leftVal + rightVal + node.val);
		return node.val + Math.max(leftVal, rightVal);
	}
}
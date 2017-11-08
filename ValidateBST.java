class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		// recurseBST(root, root.val, false);
		if(root == null)
			return true;
		return recurseBST(root.left, null, root.val) && recurseBST(root.right, root.val, null);
	}

	private boolean recurseBST(TreeNode node, Integer minVal, Integer maxVal) {
		if(node == null)
			return true;
		else if((minVal != null && node.val <= minVal) || (maxVal != null && node.val >= maxVal))
			return false;
		return recurseBST(node.left, minVal, node.val) && recurseBST(node.right, node.val, maxVal);
	}
}
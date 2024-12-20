class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        // We call the function from lvl 0, and everything starts from lvl 1
        traverse(root.left, root.right, 1);
        return root;
    }

    public void traverse(TreeNode node1, TreeNode node2, int lvl) {
        if (node1 == null || node2 == null) {
            return;
        }
        if (lvl % 2 == 1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        traverse(node1.left, node2.right, lvl + 1);
        traverse(node1.right, node2.left, lvl + 1);
    }
}
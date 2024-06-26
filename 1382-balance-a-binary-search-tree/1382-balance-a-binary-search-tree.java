class Solution {
    public TreeNode balanceBST(TreeNode root) {
         List<Integer> sortedNodes = new ArrayList<>();
        inOrderTraversal(root, sortedNodes);
        return buildBalancedBST(sortedNodes, 0, sortedNodes.size() - 1);
    }

    // In-order traversal to collect nodes in a sorted list
    private void inOrderTraversal(TreeNode node, List<Integer> sortedNodes) {
        if (node == null) return;
        inOrderTraversal(node.left, sortedNodes);
        sortedNodes.add(node.val);
        inOrderTraversal(node.right, sortedNodes);
    }

    // Build a balanced BST from sorted nodes
    private TreeNode buildBalancedBST(List<Integer> sortedNodes, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sortedNodes.get(mid));
        root.left = buildBalancedBST(sortedNodes, start, mid - 1);
        root.right = buildBalancedBST(sortedNodes, mid + 1, end);
        return root;
        
    }
}
class Solution {
    /** Check is the list is a subpath starting at head. */
    private boolean isSubPathHead(ListNode head, TreeNode root) {
        if(head == null) {
            return true;
        }
        
        if(root == null) {
            return false;
        }

        // Short-circuting boolean evaluation means that we return early
        // if the path is to the left.
        return
            (head.val == root.val)
            && (isSubPathHead(head.next, root.left)
                || isSubPathHead(head.next, root.right));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(isSubPathHead(head, root)) {
            return true;
        }
        
        if(root.left != null && isSubPath(head, root.left)) {
            return true;
        }

        if(root.right != null && isSubPath(head, root.right)) {
            return true;
        }

        return false;
    }
}
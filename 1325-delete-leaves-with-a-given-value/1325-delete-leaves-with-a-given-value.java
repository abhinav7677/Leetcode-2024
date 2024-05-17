class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        //Recursion Till The Root is null
        if(root!=null){
        root.left = removeLeafNodes( root.left, target);
        root.right = removeLeafNodes( root.right, target);
        if(root.left==null && root.right==null &&root.val==target)
            //if root has no children and root contains the value then delete node
            return null;
        return root;
        }
        return null;
    }
}
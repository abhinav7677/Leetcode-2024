class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int ans=0;
        if(root==null)
            return 0;
            if(root.left!=null)
            {
                if(root.left.left==null && root.left.right==null)
                    ans+=root.left.val;
                else
                    ans +=sumOfLeftLeaves(root.left);     
            }
            ans +=sumOfLeftLeaves(root.right);
                    
            return ans;
    }
}
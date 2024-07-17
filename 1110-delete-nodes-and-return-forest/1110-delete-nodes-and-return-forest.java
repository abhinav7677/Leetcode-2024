class Solution {
    public static void find(TreeNode root,TreeNode par,Set<Integer>set,List<TreeNode>ans){
        if(set.size()==0 || root==null){
            return;
        }

        find(root.left,root,set,ans);
        find(root.right,root,set,ans);
        
        int num = root.val;
        if(set.contains(num)){
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right!=null){
                ans.add(root.right);
            }

            if(par.left!=null && par.left.val==num ){
                par.left = null;
            }else if(par.right!=null && par.right.val==num ){
                par.right = null;
            }
            set.remove(num);
        } 
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        TreeNode par = new TreeNode(-1);
        Set<Integer>set = new HashSet<>();
        Set<Integer>check = new HashSet<>();
        for(int i=0; i<to_delete.length; i++){
            set.add(to_delete[i]);
            check.add(to_delete[i]);
        }
        List<TreeNode>ans = new ArrayList<>();
        find(root,par,set,ans);
        if(!check.contains(root.val)){
            ans.add(0,root);
        }
        
        return ans;
    }
}
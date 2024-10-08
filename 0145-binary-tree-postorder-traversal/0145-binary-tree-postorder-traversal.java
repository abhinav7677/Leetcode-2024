class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr =new ArrayList<>();
        if(root==null) return arr;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(st.size()!=0){
            TreeNode temp=st.peek();
              
            if(temp.left!=null) {
                st.push(temp.left);
                temp.left=null;
            }else if(temp.right!=null){
                st.push(temp.right);
                temp.right=null;
            }else {
                arr.add(temp.val);
                st.pop();
        }
        }
        return arr;
    }
}

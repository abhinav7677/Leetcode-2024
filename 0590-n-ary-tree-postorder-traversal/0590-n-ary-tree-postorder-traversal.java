class Solution {
    public List<Integer> postorder(Node root) {
        return solve(root, new ArrayList());
    }
    private List<Integer> solve(Node root, List<Integer> list){
        if(root == null){
            return list;
        }
        for(Node child : root.children){
            solve(child, list);
        }
        list.add(root.val);
        return list;
    }
}
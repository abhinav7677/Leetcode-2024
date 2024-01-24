class Solution {
    int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        Map<Integer,Integer> maps=new HashMap<>();
        dfs(root,maps);
        return ans;
    }
    
    public void dfs(TreeNode root, Map<Integer,Integer> maps)
    {
        if(root==null)
        {
            return;
        }
        
        maps.put(root.val,maps.getOrDefault(root.val,0)+1);
        
        if(root.left==null && root.right==null)
        {
            int count=0;
            
            for(int i:maps.values())
            {
                if(i%2==1)
                {
                    count++;
                }
            }
            
            if(count<=1)
            {
                ans++;
            }
        }
        
        else
        {
            dfs(root.left,maps);
            dfs(root.right,maps);
        }
        
        maps.put(root.val,maps.get(root.val)-1);
        if(maps.get(root.val)==0)
        {
            maps.remove(root.val);
        }
    }
}
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>res=new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        Map<Integer,List<Integer>>list=new HashMap<>();
        for(int i=0; i<n; i++){
            list.put(i,new ArrayList<>());
        }
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        List<Integer>LeafNode=new ArrayList<>();
        for(int i=0; i<n; i++){
            if(list.get(i).size()==1){
                LeafNode.add(i);
            }
        }
        while(n>2){
            n-=LeafNode.size();//reduce total number of nodes by removing LeafNode.
            List<Integer>newLeaf=new ArrayList<>();
            for(int leaf:LeafNode){
                int neighbor=list.get(leaf).get(0);//remove the leaf node.
                list.get(neighbor).remove(Integer.valueOf(leaf));
                if(list.get(neighbor).size()==1){
                    newLeaf.add(neighbor);//new leaf added to the list
                }
            }
            LeafNode=newLeaf;
        }
        return LeafNode;
    }
}
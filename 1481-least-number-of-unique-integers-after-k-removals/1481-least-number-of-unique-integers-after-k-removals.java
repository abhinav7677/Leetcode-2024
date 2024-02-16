class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        HashMap<Integer,Integer> hm=new HashMap<>();
        ArrayList<Integer> al=new ArrayList<>();
        // ADD ALL VALUES TO HASHMAP
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        //ADD ALL HM VALUES TO ARRAYLIST
        for(int i:hm.values()){
            al.add(i);
        }

        Collections.sort(al); // SORT IT 
        //ITERATE OVER VALUES
        for(int i=0;i<al.size();i++){
            k-=al.get(i);
            if(k<0)
            return al.size()-i;
        }
        return 0;
        
    }
}
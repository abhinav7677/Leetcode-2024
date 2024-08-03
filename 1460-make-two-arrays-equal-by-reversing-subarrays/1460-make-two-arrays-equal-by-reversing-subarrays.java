class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
       // if(target.length!=arr.length)return false;
        // Arrays.sort(target);
        // Arrays.sort(arr);
        // for(int i=0;i<arr.length;i++){
        //     if(target[i]!=arr[i])return false;
        // }
        // return true;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
           map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(target[i]))return false;
            map.put(target[i],map.get(target[i])-1);
            if(map.get(target[i])==0)map.remove(target[i]);
        }
        return map.size()==0;
      
    }
}
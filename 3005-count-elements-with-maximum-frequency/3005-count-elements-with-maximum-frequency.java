class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> M=new HashMap<Integer,Integer>();
        int max=0;
        int n;
        for(int digit:nums){
            M.put(digit,M.getOrDefault(digit,0)+1);
        }
        int count=0;
        for (Map.Entry<Integer, Integer> entry : M.entrySet()) {
            if(entry.getValue()>max){
                max=entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : M.entrySet()) {
            if(entry.getValue()==max){
                count++;
            }
        }
        
        return max*count;
    }
}
class Solution {

    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] newSysArray = createNewSystemArray(mapping, nums);
        Integer[] indexes = new Integer[n];
        for(int i=0; i<n; i++) indexes[i] = i;
        Arrays.sort(indexes, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return newSysArray[a]-newSysArray[b];
            }
        });
        int[] res = new int[n];
        int i=0;
        for(int index: indexes){
            res[i++] = nums[index];
        }
        return res;
    }


    public int[] createNewSystemArray(int[] mapping, int[] nums){
        int n=nums.length;
        int[] newSys = new int[n];
        for(int j=0; j<n; j++){
            int num = nums[j];
            if(num == 0){
                newSys[j] = mapping[0];
                continue;
            }
            int res=0;
            int i=0;
            while(num > 0){
                int d = num%10; ///digit extraction
                int newDigit = mapping[d]; //digit in new system
                res = newDigit*(int)Math.pow(10,i)+res;
                num = num/10;
                i++;
            }
            newSys[j] = res;
        }
        return newSys;
    }
}

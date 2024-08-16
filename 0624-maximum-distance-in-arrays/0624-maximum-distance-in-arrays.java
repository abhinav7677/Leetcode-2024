class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
int min=arrays.get(0).get(0);
int max=arrays.get(0).get(arrays.get(0).size()-1);
int result=0;
for(int i=1;i<arrays.size();i++){
       int currMin=arrays.get(i).get(0);
       int currMax=arrays.get(i).get(arrays.get(i).size()-1);
        result =Math.max(result,Math.abs(currMax-min));
        result =Math.max(result,Math.abs(max-currMin));

        min=Math.min(min,currMin);
        max=Math.max(max,currMax);

}
return result;
    }
}
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)  return new int[]{-1,-1};
        int[] ans=new int[2];
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        ArrayList<Integer> criticalPoints =new ArrayList<>();
        for(int i=1; i< arr.size()-1;i++){
            if((arr.get(i) > arr.get(i-1) && arr.get(i) > arr.get(i+1))
                || (arr.get(i) < arr.get(i-1) && arr.get(i) < arr.get(i+1))){
                    criticalPoints.add(i);
            }
        }
        int n=criticalPoints.size();
        if(n<2){
            ans[0]=-1;
            ans[1]=-1;
        }
        else{
            int min=Integer.MAX_VALUE;
            for(int i =1 ; i<n; i++){
                min=Math.min(min , criticalPoints.get(i) - criticalPoints.get(i-1));
            }
            ans[0]=min;
            ans[1] = criticalPoints.get(n-1) - criticalPoints.get(0);
        }
        return ans;

    }
}
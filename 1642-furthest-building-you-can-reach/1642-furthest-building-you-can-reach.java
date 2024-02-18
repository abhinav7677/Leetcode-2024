class Solution {
    public int furthestBuilding(int[] h, int brk, int lad) {
        int n=h.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int numEle=0;
        for(int i=0;i<n;i++){
            int d=h[i]-((i>0) ? h[i-1] : h[i]);
            if(d<=0) continue;
            numEle++;
            pq.add(d);
            if(numEle<=lad){
                continue;
            }
            if(pq.peek()<=brk){
                brk-=pq.poll();
            }
            else return i-1;
        }
        return n-1;
    }
}
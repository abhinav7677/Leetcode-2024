class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        if(k==1)return new int[]{arr[0],arr[n-1]};
        int[][] taken=new int[n][n];

        //we can put the fraction and indexes as pair of pair in a pq

        PriorityQueue<Pair<Double, Pair<Integer, Integer>>> pq=new PriorityQueue<>((a,b) -> Double.compare(a.getKey(),b.getKey()));
        //intiially we know the samellest fraction would be of 1st and last index so we insert that
        pq.offer(new Pair<Double, Pair<Integer,Integer>>((double)arr[0]/arr[n-1], new Pair<>(0,n-1)));
        taken[0][n-1]=1; //we mark it as already taken
        int firstVal=0; //we will store answer basically the indexes into two variables
        int secondVal=0;

        while(!pq.isEmpty() && k>0){
            double currFrac=pq.peek().getKey();
            int left=pq.peek().getValue().getKey();
            int right=pq.peek().getValue().getValue();
            pq.poll();
            //so we will poll element from pq one by one which will be smallest fraction as the pq is min heap based on fraction
            //store the current answer into the variables
            firstVal=left;
            secondVal=right;
            --k; //decrease k as we got one smallest fraction pari
            //now for current two indexes left and right we will check all possible fraction which can be generated based on below rules
            //possibilities would be below only if these are valid index, there fraction is greater than currFrac and left<right
            //decrease left - chaneg right -1, 0, 1
            // keep left same - change right -1,0,1
            //increase left - change right -1,0,1 

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int newLeft=left+i;
                    int newRight=right+j;
                    //we also want to ensure newleft < newright and both are valid indexes and not already taken
                    if(newLeft<newRight && newLeft>=0 && newRight<n && taken[newLeft][newRight]==0){
                        taken[newLeft][newRight]=1; //take them and insert into pq
                        pq.offer(new Pair<Double, Pair<Integer,Integer>>((double)arr[newLeft]/arr[newRight], new Pair<>(newLeft, newRight)));
                    }
                }
            }
        }
return new int[]{arr[firstVal],arr[secondVal]}; //once above loop ends we will have indexes of kth smallest pair fraction we can just get the values and return them
    }
}
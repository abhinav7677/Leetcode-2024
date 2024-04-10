class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int second = 0, n = tickets.length;

        while(tickets[k] != 0){
            for(int i=0; i<n; i++){
                if(tickets[k] == 0){
                    return second;
                }
                if(tickets[i] > 0){
                    tickets[i]--;
                    System.out.println("tickets : "+i+" "+tickets[i]);
                    second++;
                    System.out.println("second : "+second);
                }
                else if(tickets[i] == 0 && i != k){
                    continue;
                }
            }
        }

        return second;
    }
}
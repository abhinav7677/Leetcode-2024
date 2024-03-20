class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur=list1;

        for(int i=0;i<a-1;i++){
            cur=cur.next;
        } 

        ListNode start_from_here=cur;

        for(int i=a;i<=b+1;i++){
            cur=cur.next;
            // now my linked list pointer is at 5
        }
        
    start_from_here.next=list2;
       while(list2.next!=null){
         list2=list2.next;
       }
        // connect the second list to the first after removing the interval
       list2.next=cur;

       return list1;

    }
}
 class Node {
    int val;
    Node next;

    Node(int data) {
        this.val = data;
        this.next = null;
    }
}class Solution {
    public int findTheWinner(int n, int k) {
        Node head=new Node(1);
        Node temp=head;
        for(int i=2;i<=n;i++){
            Node node=new Node(i);
            temp.next=node;
            temp=temp.next;
        }
        temp.next=head;
        Node prev=temp;
        int count=1;
         temp=head;
        while(prev.next!=prev){
            if(count==k){
                prev.next=temp.next;
                temp=temp.next;
                count=1;

            }
            else{
                ++count;
                prev=temp;
                temp=temp.next;
            }

        }
        return prev.val;
      
        
    }
}
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            int firstNode = temp.val;
            ListNode temp2 = temp.next;
            int secondNode = temp2.val;

            ListNode midNode = new ListNode(gcd(Math.max(firstNode, secondNode), Math.min(firstNode, secondNode)));
            // WE USE Math.max() and Math.min() TO SEND WHICH IS GREATER AND SMALLER TO AVOID DIV BY 0 ERROR
            temp.next = midNode; 
            midNode.next = temp2; 

            temp = temp2;
        }

        return head; 
    }

    private static int gcd(int x1, int x2)      // OPTIMIZED LOGIC FOR GCD
    {
        if (x2 == 0) return x1;  // Base case
        return gcd(x2, x1 % x2); // Recursive call
    }
}
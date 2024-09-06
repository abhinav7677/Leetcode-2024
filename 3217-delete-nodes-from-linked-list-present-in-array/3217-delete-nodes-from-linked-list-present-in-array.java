class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
       HashSet<Integer> set = new HashSet<>();
       for(int num : nums) set.add(num);
       ListNode dummy = new ListNode(0);
       ListNode ptr = dummy;
       ListNode curr = head;
       while(curr != null) {
         int val = curr.val;
       
        if(set.contains(val)) {
            curr = curr.next;
            ptr.next = null;
        }
        else {
            ptr.next = curr;
            ptr = ptr.next;
            curr = curr.next;
        }
       }
      return dummy.next;  
    }
}
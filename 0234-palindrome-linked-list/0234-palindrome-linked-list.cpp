class Solution {
public:
    bool isPalindrome(ListNode* head) {
     stack<int> firstHalf;
        
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast!=nullptr && fast->next!=nullptr){
           firstHalf.push(slow->val) ;
            slow = slow->next;
            fast = fast->next->next;
        }
        if(fast!=nullptr){
            slow=slow->next ;
        }
        while(slow!=nullptr){
            if(slow->val!=firstHalf.top()){
                return false ;
            }
            slow=slow->next ;
            firstHalf.pop() ;
        }
       
       return true ;
    }
};
class Solution {
public:
    ListNode* reverse(ListNode* head){
        ListNode* prev=NULL;
        ListNode* nxt=NULL;
        while(head){
            nxt=head->next;
            head->next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
    void reorderList(ListNode* head) {
        ListNode* slow=head;ListNode* fast=head;
        while(fast->next!=nullptr && fast->next->next!=nullptr){
            slow=slow->next;
            fast=fast->next->next;
        }
        slow->next=reverse(slow->next);
       
        ListNode* ptr1=head;ListNode* ptr2=slow->next;
        while(ptr2!=NULL){
            ListNode* temp1=ptr1->next;
            if(temp1==slow->next)temp1=NULL;
            ListNode* temp2=ptr2->next;

            ptr1->next=ptr2;
            ptr1->next->next=temp1;
            ptr1=ptr1->next->next;
            ptr2=temp2;
        }
        if(ptr1)
        ptr1->next=NULL;
    }   
};
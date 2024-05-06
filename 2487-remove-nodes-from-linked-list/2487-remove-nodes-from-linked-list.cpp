class Solution {
public:
    // This function removes the node which has nodes with greater value in right
    void remove_node(ListNode *trav)
    {
        int max_val=trav->val;
        ListNode *tmp=trav;
        while(tmp->next!=NULL)
        {
            // If next node value is less than max_val then remove next node
            if(tmp->next->val < max_val)
            {
                tmp->next=tmp->next->next;
            }
            else // Else update the max_val
            {
                max_val=tmp->next->val;
                tmp=tmp->next;
            }
        }
    }

// This function reverse the LinkedList and return the head pointer
    ListNode* reverse_list(ListNode *head)
    {
        if(head==NULL || head->next==NULL) return head;
        ListNode *prev=NULL,*curr=head,*Next=head->next;

        while(curr!=NULL)
        {
            Next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=Next;
        }
        return prev;
    }

    ListNode* removeNodes(ListNode* head) {

        // Algorithm:
        // First reverse the Linkedlist then traverse the list and keep updating
        // the max_val found till now. 
        // Compare if curr_node value is less than max_val then remove curr_node
        // At the end we will left with the result nodes in reverse order
        // Now again reverse the resulting list to get the ans.

        ListNode *trav=reverse_list(head); // Reverse list

        remove_node(trav);      // Remove required nodes
        
        return reverse_list(trav); // Reverse list to get ans
    }
};
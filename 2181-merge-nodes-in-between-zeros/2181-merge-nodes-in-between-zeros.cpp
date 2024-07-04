/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeNodes(ListNode* head) {
        ListNode* res = head;
        ListNode* ans = res;
        ListNode* curr = head->next;
        int curr_sum = 0;
        while(curr->next!=NULL){
            if(curr->val==0){
                ListNode* temp = new ListNode(curr_sum);
                res->next = temp;
                res= res->next;
                curr_sum = 0;
            }
            else{
                curr_sum+=curr->val;
            }
            
            curr = curr->next;
        }
        ListNode* temp = new ListNode(curr_sum);
        res->next = temp;
        return ans->next;
    }
};
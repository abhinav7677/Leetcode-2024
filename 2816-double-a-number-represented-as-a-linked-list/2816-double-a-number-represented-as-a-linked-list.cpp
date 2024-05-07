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
 ListNode* reverse(ListNode* head) {
        if (head == NULL)
            return NULL;
        if (head->next == NULL) {
            return head;
        }
        ListNode* prev = NULL;
        ListNode* curr = head;
        ListNode* forward = curr->next;
        while (curr != NULL && forward != NULL) {
            forward = curr->next;
            curr->next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
    ListNode* doubleIt(ListNode* head) {
        ListNode* temp = reverse(head);
        int carry = 0;
        ListNode* temp1 = temp;
        ListNode* lastNode = NULL;
        while (temp != NULL) {
            int ele = temp->val * 2 + carry;
            carry = ele / 10;
            temp->val = ele % 10;
            lastNode = temp;
            temp = temp->next;
        }
        if (carry) {
            lastNode->next = new ListNode(carry);
        }
        return reverse(temp1);
        
    }
};
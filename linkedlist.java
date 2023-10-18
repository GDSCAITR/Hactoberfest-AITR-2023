class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *dummy = NULL;
        int v3 = 0;
        int carry = 0;
        
        while (l1 && l2  && v3 > 0){
            int v1 = l1->val;
            int v2 = l2->val;
            
            // when l1 reaches the end. Set v1 to 0
            if(l1->next == NULL){
                v1 = 0;
            }
            if(l2->next == NULL){
                v2 = 0;
            }
            
            v3 = (v1 + v2 + carry);
            carry = v3 / 10;
            int insert_value = v3 % 10;
            
            ListNode *newNode = new ListNode(insert_value);
            
            if(dummy == NULL){
                dummy = newNode;
            } else {
                ListNode *head = dummy;
                while (dummy->next){
                    dummy = dummy->next;
                    
                    dummy->next = newNode;
                    dummy = head;
                }
            }
            
            if(l1->next != NULL){
                l1 = l1->next;
            }
            if(l2->next != NULL){
                l2 = l2->next;
            }
        }
        return dummy;
    }
};

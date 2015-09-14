/** Remove Linked List Elements **/
/*=======================================================================
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
=======================================================================*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        
        // deal with head first
        while(head!=null && head.val==val){
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        
        // deal with the other part
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            if(cur.next.val==val){
                cur.next = cur.next.next;   
            }
            else{
                cur = cur.next;
            }
        }
        
        return head;
    }
}
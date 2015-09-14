/** Add Two Numbers **/
/*============================================================================
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
============================================================================*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        ListNode head = new ListNode(0);
        ListNode res = head;
        int carry = 0;
        int sum = 0;
        while(l1!=null && l2!=null){
            sum = (l1.val+l2.val+carry)%10;
            carry = (l1.val+l2.val+carry)/10;
            ListNode temp = new ListNode(sum);
            head.next = temp;
            head = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null || l2!=null){
            if(l2!=null){
                sum = (l2.val+carry)%10;
                carry = (l2.val+carry)/10;
                ListNode temp = new ListNode(sum);
                head.next = temp;
                head = temp;
                l2 = l2.next;
            }
            if(l1!=null){
                sum = (l1.val+carry)%10;
                carry = (l1.val+carry)/10;
                ListNode temp = new ListNode(sum);
                head.next = temp;
                head = temp;
                l1 = l1.next;
            }
        }
        
        if(carry!=0){
            ListNode temp = new ListNode(carry);
            head.next = temp;
            head = temp;
        }
        
        return res.next;
    }
}
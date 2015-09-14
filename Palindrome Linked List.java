/** Palindrome Linked List**/
/*===============================================================
Given a singly linked list, determine if it is a palindrome.
================================================================*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// fast and slow pointer algorithm
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;   
        }
        // find the mid point
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse linked list
        ListNode mid = slow.next;
        ListNode pre = null;
        while(mid!=null){
            ListNode temp = mid.next;
            mid.next = pre;
            pre = mid;
            mid = temp;
        }
        // compare
        ListNode head1 = head;
        ListNode head2 = pre;
        while(head2!=null){
            if(head1.val==head2.val){
                head1 = head1.next;
                head2 = head2.next;
            }
            else{
                return false;
            }
        }
        return true;
        
    }
}
/** Intersection of Two Linked Lists **/
/*==============================================================================================
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
==============================================================================================*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null) return null;
        if(headB==null) return null;
        ListNode head1 = headA;
        ListNode head2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(head1!=null){
            head1 = head1.next;
            len1++;
        }
        while(head2!=null){
            head2 = head2.next;
            len2++;
        }
        if(len1>len2){
            for(int i=0; i<len1-len2; i++){
                headA = headA.next;
            }
        }
        else if(len2>len1){
            for(int i=0; i<len2-len1; i++){
                headB = headB.next;
            }
        }
        
        while(headA!=null&&headB!=null){
            if(headA.val==headB.val){
                return headA;
            }
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        
        return null;
    }
}
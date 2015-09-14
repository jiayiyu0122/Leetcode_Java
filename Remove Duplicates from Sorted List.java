/** Remove Duplicates from Sorted List **/
/*===========================================================================================
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
===========================================================================================*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        Set<Integer> hs = new HashSet<Integer>();
        while(head!=null && head.next!=null){
            if(!hs.contains(head.next.val)){
                hs.add(head.next.val);
                head = head.next;
            }
            else{
                head.next = head.next.next;
            }
        }
        
        return dummy.next;
        
    }
}
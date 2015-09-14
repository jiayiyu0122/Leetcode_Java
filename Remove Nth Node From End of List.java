/** Remove Nth Node From End of List **/
/*===================================================================================
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
===================================================================================*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// two pass的方法就是遍历一遍list得到长度，然后再删除节点
// one pass的方法是用快慢指针
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        
        // 要删除的是头结点
        if(fast==null){
            head = head.next;
            return head;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
        
    }
}

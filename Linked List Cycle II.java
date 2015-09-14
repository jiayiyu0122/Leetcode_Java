/**
 * Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null
 */
/*
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){ return head; }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(fastPointer!=null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                break;
                }
            }
        
        if(fastPointer == null || fastPointer.next == null){
            return null;
        }
        slowPointer = head;
        while(slowPointer != fastPointer){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
       
        }
         return slowPointer;
    }
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

            
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        
        if(fast.next==null || fast.next.next==null) return null;
        
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
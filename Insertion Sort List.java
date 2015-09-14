/** Insertion Sort List **/
/*===========================================
Sort a linked list using insertion sort.
===========================================*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// 这道题用了一个小技巧，先在表头加入一个dummy node, 但是表头不要和head连起来，这样可以省去很多swap的时候的麻烦。
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null){
            pre = dummy;
            ListNode next = cur.next;
            while(pre.next!=null && pre.next.val<=cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
}
}
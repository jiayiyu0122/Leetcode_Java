/** Merge k Sorted Lists **/

/*==============================================================================================
Merge k sorted linked lists and return it as one sorted list. 
Analyze and describe its complexity.
===============================================================================================*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 分治法

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return helper(lists,0,lists.length-1);
    }
   
    public ListNode helper(ListNode[] lists,int l, int r){
        if(l<r){
            int m = (l+r)/2;
            return merge(helper(lists,l,m),helper(lists,m+1,r));
        }
        return lists[l];
    }
    
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1==null) return h2;
        if(h2==null) return h1;
        ListNode head = h1.val<h2.val? h1:h2;
        ListNode cur = head;
        if(head==h1) h1 = h1.next;
        if(head==h2) h2 = h2.next;
        
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                ListNode temp = h1.next;
                cur.next = h1;
                cur = h1;
                h1 = temp;
            }
            else{
                ListNode temp = h2.next;
                cur.next = h2;
                cur = h2;
                h2 = temp;
            }
        }
        
        if(h1==null){
            cur.next = h2;
        }
        if(h2==null){
            cur.next = h1;
        }
        return head;
    }
}
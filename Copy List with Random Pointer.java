/** Copy List with Random Pointer **/
/*============================================================
A linked list is given such that each node contains an additional 
random pointer which could point to any node in the list or null.

Return a deep copy of the list.
============================================================*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return head;
        RandomListNode newHead = new RandomListNode(head.label);
        HashMap<RandomListNode,RandomListNode> hm = new HashMap<RandomListNode,RandomListNode>();
        
        hm.put(head,newHead);
        //复制没有random指针的linked list
        while(head!=null){
            if(head.next !=null){
                if(hm.containsKey(head.next)){
                    hm.get(head).next = hm.get(head.next);
                }
                else{
                    RandomListNode temp = new RandomListNode(head.next.label);
                    hm.put(head.next,temp);
                    hm.get(head).next = temp;
                    
                }
            }
            if(head.random !=null){
                if(hm.containsKey(head.random)){
                    hm.get(head).random = hm.get(head.random);
                }
                else{
                    RandomListNode temp = new RandomListNode(head.random.label);
                    hm.get(head).random = temp;
                    hm.put(head.random,temp);
                }
            }
            head = head.next;
        }
        return newHead;
    }
    
    
}
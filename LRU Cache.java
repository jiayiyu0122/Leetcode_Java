/** LRU Cache **/

/*==================================================================
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
==================================================================*/

public class LRUCache {
    int capacity;
    HashMap<Integer,Node> hm = new HashMap<Integer,Node>();
    Node head = null;
    Node end = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            remove(temp);
            setHead(temp);
            return temp.val;
        }
        return -1;
        
    }
    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }
        else{
            head = n.next;
        }
        if(n.next!=null){
            n.next.pre = n.pre;
        }
        else{
            end = n.pre;
        }
    }
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
        
        if(head!=null){
            head.pre = n;
        }
        head = n;
        if(end==null){
            end = head;
        }
    } 
    
    public void set(int key, int value) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            temp.val = value;
            remove(temp);
            setHead(temp);
        }
        else{
            Node temp = new Node(key,value);
            if(hm.size()>=capacity){
                hm.remove(end.key);
                remove(end);
                setHead(temp);
            }
            else{
                setHead(temp);
            }
            hm.put(key,temp);
            
        }
    }
}

    


class Node {
    int key;
    int val;
    Node next;
    Node pre;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
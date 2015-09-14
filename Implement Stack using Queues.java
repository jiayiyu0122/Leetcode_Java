/** Implement Stack using Queues  **/
/*==================================================================================================================================
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
====================================================================================================================================*/
class MyStack {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.push(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!queue.isEmpty()){
            int head;
            if(queue.size()==1) head = queue.poll();
            else{
                int size = queue.size();
                for(int i=0; i<size-1; i++){
                    head = queue.poll();
                    queue.push(head);
                }
                head = queue.poll();
            }
        }
    }

    // Get the top element.
    public int top() {
        int head=0;
        if(!queue.isEmpty()){
            if(queue.size()==1) head = queue.peek();
            else{
                int size = queue.size();
                // 把元素后移
                for(int i=0; i<size-1; i++){
                    head = queue.poll();//retrive and remove
                    queue.push(head);
                }
                head = queue.peek();
                queue.push(queue.poll());
            }
        }
        return head;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
        
    }
}
/** Implement Queue using Stacks **/
/*==================================================================================================================================
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
==================================================================================================================================*/

class MyQueue {
    LinkedList<Integer> mainStack = new LinkedList<Integer>();
    LinkedList<Integer> helpStack = new LinkedList<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        mainStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        int size = mainStack.size();
        if(size==1) mainStack.pop();
        else{
            // pop all elements above the first elemnt from the stack
            for(int i=size-1; i>0; i--){
                helpStack.push(mainStack.pop());
            }
            mainStack.pop();
            // put all element back
            for(int i=size-1; i>0; i--){
                mainStack.push(helpStack.pop());
            }
        }
    }

    // Get the front element.
    public int peek() {
        int head = 0;
        int size = mainStack.size();
        if(size==1) head = mainStack.get(0);
        else{
            // pop all elements above the first elemnt from the stack
            for(int i=size-1; i>0; i--){
                helpStack.push(mainStack.pop());
            }
            head = mainStack.peek();
            // put all element back
            for(int i=size-1; i>0; i--){
                mainStack.push(helpStack.pop());
            }
        }
        return head;
    }

    // Return whether the queue is empty.
    public boolean empty() {
       return mainStack.isEmpty();
    }
}
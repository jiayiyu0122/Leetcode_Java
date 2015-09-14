/** Min Stack **/
/*================================================================================================
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
================================================================================================*/
// 注意 stack.pop()返回的是objects所以对比两个数相等的时候要用objects.equals()来实现
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if(minStack.empty()||x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            if(stack.pop().equals(minStack.peek())){
                minStack.pop();
            }
        }
        
    }

    public int top() {
        if(!stack.empty()){
            return stack.peek();
        }
        return 0;
    }

    public int getMin() {
        if(!minStack.empty()){
            return minStack.peek();
        }
        return 0;
    }
}

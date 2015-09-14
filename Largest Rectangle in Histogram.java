/** Largest Rectangle in Histogram **/
// 这道题目用得是stack的方法
// 当前的元素比栈最上面那个元素大的话，就入栈。小的话就pop()出来计算面积
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height.length==0) return 0;
        int Len = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        while(i<Len){
            if(stack.empty()||height[i]>=height[stack.peek()]){
                stack.push(i);
                i++;
            }
            else{
                int index = stack.pop();
                int w = stack.empty()? i:i-stack.peek()-1;
                int area = height[index]*w;
                maxArea = Math.max(area,maxArea);
            }
        }
        
        while(!stack.empty()){
            int index = stack.pop();
            int w = stack.empty()? i:i-stack.peek()-1;
            int area = height[index]*w;
            maxArea = Math.max(area,maxArea);
            
        }
        
        return maxArea;
        
    }
}